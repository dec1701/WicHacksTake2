<div class="taskList">
    <#list tasks as t>
        <form action="./edit?taskId=${t.getId()}" method="post">
            <button type="submit" formmethod="post">${t.getDescription()}</button>
        </form>
    </#list>
</div>