<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SearchEngine</title>
    <style>
    </style>
</head>
<body>
     <div class="header">
        <form action="/search" method = "post">
            <h1> Simple Search Engine</h1>
            <div class="form-box">

                <input type="text" id="search" name="search" class="search-field" placeholder="search keyword" value="${value}">
                <select name="strategy" id="strategy" class="search-field-strategy">
                  <option value="ANY">ANY</option>
                  <option value="ALL">ALL</option>
                  <option value="NONE">NONE</option>
                </select>
                <button class="search-btn" type="submit">Search</button>

            </div>
            <div>
                <#list results as result>
                       <h1><a href="/files?file=${result}">${result}</a></h1>
                        <br><br>
                </#list>
            </div>
        </form>
       </div>
</body>
</html>