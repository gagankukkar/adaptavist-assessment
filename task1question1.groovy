import com.atlassian.jira.component.ComponentAccessor

def EXPECTEDTIME = 10115
def ACTUALTIME = 10116

def customFieldManager = ComponentAccessor.customFieldManager

def expectedTime = customFieldManager.getCustomFieldObject(EXPECTEDTIME)
def expectedTimeValue = issue.getCustomFieldValue(expectedTime)

def actualTime = customFieldManager.getCustomFieldObject(ACTUALTIME)
def actualTimeValue = issue.getCustomFieldValue(actualTime)

def timeDiff

if (expectedTimeValue && actualTimeValue) {
    timeDiff = actualTimeValue - expectedTimeValue
    return timeDiff
} else {
    return null
}
