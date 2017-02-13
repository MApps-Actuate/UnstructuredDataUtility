var projects, updateProject;

$(document).ready(function () {
	$.getJSON("projects").done(function (data) {
		doResponse(data, loadProjects);
	}).fail(error);

	$("#loadForm").ajaxForm({
		dataType: "json",
		clearForm: true,
		error: error,
		beforeSubmit: function () {
			if ($("#dataFile")[0].files.length == 0) {
				error("No file selected");
				return false;
			}
			//TODO: put up a spinning something to say we are working on it
			return true;
		},
		success: function (data) {
			//TODO: clear spinning something to say we are done working on it
			doResponse(data, loadProjectSuccess);
		},
		uploadProgress: function (evt, pos, total, pct) {
			//todo: implement a progress bar
		}
	});

	$("#newForm").ajaxForm({
		dataType: "json",
		clearForm: true,
		error: error,
		beforeSubmit: function (data) {
			var password = getFormDataValue("password", data);
			var passwordConfirm = getFormDataValue("passwordConfirm", data);

			if (password == "") {
				error("Password not specified");
				return false;
			}
			if (password != passwordConfirm) {
				error("Passwords do not match");
				return false;
			}

			return true;
		},
		success: function (data) {
			doResponse(data, newProjectSuccess);
		}
	});

	$("#updateForm").ajaxForm({
		type: "PUT",
		dataType: "json",
		clearForm: true,
		error: error,
		beforeSubmit: function (data, $form, options) {
			options.url += "/" + updateProject.id;
		},
		success: function (data) {
			doResponse(data, updateProjectSuccess);
		}
	});

	$("#showSettings").click(openProjectSettings);
	$("#closeUpdate").click(closeProjectSettings);
	$("#settingsItems").on("click", ".removeSetting", removeSetting);
	$("#addNewSetting").click(addNewSetting);
	$("#overlay").height($(document).outerHeight(true));
});

function getFormDataValue(name, data) {
	var val = null;
	$.each(data, function(i, d) {
		if (d.name == name) {
			val = d.value;
			return false;
		}
	});
	return val;
}

function doResponse(data, callback) {
	if (data.status) {
		callback(data);
	} else {
		error(data);
	}
}

function loadProjectSuccess(data) {
	var project = data.result.project;
	var loadResult = data.result.loaderResults;

	var message = "Load into " + project.name + " finished\n\n";
	message += "Elapsed Time (ms): " + loadResult.elapsed + "\n\n";
	message += "Success: " + loadResult.success + "\n";
	message += "Skipped: " + loadResult.skipped + "\n";
	message += "Failed: " + loadResult.failed + "\n";
	message += "Total: " + loadResult.total + "\n\n";

	inform(message);
}

function newProjectSuccess(data) {
	inform("Project " + data.result.project.name + " created successfully");
	$("#loadForm").clearForm();
	loadProjects(data);
	$("#projectSelect").val(data.result.project.id);
}

function updateProjectSuccess(data) {
	inform("Updated settings for " + data.result.project.name);

	$("#loadForm").clearForm();
	loadProjects(data);
	$("#projectSelect").val(data.result.project.id);

	$("#settingsItems").empty();
	$("#updateForm").clearForm();
	$("#update").hide();
	$("#overlay").hide();
}

function loadProjects(data) {
		var $projectSelect = $("#projectSelect");
		$projectSelect.empty();
		projects = data.result.projects.sort(function(a, b) {
			return a.name < b.name ? -1 : 1;
		});
		$.each(projects, function (i, p) {
			$projectSelect.append($("<option>", {value: p.id, text: p.name}))
		});
}

function openProjectSettings(evt) {
	evt.preventDefault();

	var id = $("#projectSelect").val();
	updateProject = projects.find(function(p) {
		return p.id == id;
	});

	$("#overlay").show();

	var $updateSettings = $("#update");
	$updateSettings.find("h1").text(updateProject.name + " - Loader Settings");

	if (updateProject.loaderSettings) {
		$.each(updateProject.loaderSettings, function(name, value) {
			var $settingsItem = addNewSetting();
			$settingsItem.find(".settingName").val(name);
			$settingsItem.find(".settingValue").val(value);
		});
	} else {
		addNewSetting();
	}

	$updateSettings.show();
}

function closeProjectSettings() {
	$("updateForm").clearForm();
	$("#settingsItems").empty();
	$("#update").hide();
	$("#overlay").hide();
}

function removeSetting(evt) {
	evt.preventDefault();
	$(this).parents(".settingsItem").remove();
}

function addNewSetting(evt) {
	if (evt)
		evt.preventDefault();

	return $("#settingsItemTemplate").find(".settingsItem").clone().appendTo("#settingsItems");
}

function inform(msg) {
	alert(msg);
}

function error(errorData) {
	var alertText = "ERROR\n";

	if (typeof errorData == "string") {
		alertText += errorData;
	} else {
		if (errorData.responseJSON) {
			errorData = errorData.responseJSON;
		} else if (!errorData.result) {
			errorData.result = {
				code: -1,
				description: errorData.responseText
			};
		}
		alertText += "Code: " + errorData.result.code + "\n";
		alertText += errorData.result.description;
	}

	alert(alertText);
}