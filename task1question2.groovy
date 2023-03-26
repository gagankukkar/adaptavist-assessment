import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.component.ComponentAccessor

def issue = event.issue

def comment = ComponentAccessor.getCommentManager().getLastComment(issue).body
if (comment) {
    issue.setDescription(comment)
    def issueManager = ComponentAccessor.getIssueManager()
    issueManager.updateIssue(null, issue, EventDispatchOption.ISSUE_UPDATED, false)
}
