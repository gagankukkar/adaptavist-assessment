import com.atlassian.jira.issue.IssueConstantImpl

def action = getActionName()

if (action == 'Create') {
    def priority = getFieldById(getFieldChanged())
    def selectedPriority = ((IssueConstantImpl) priority.getValue()).getName()

    def summary = getFieldById('summary')

    if (selectedPriority == 'High' || selectedPriority == 'Highest') {
        summary.setFormValue('URGENT: ')
    } else {
        summary.setFormValue('')
    }
}
