<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SearchEngine</title>
    
    <style>
    	body * {
    		background-color: #FFFAFA;
    	}
    	body {
    		background-color: #FFFAFA;
    	}

    	h1 {
    		text-align: center;
    		margin-top: 40px;
    		font-size: 50px;
    		font-family: Avenir Black;
    	}

    	.form-box {
    		margin-top: 70px;
    		text-align: center;
    	}

    	.form-box * {
    		margin: auto;
    		margin-right: 30px;
    		font-size: 20px;
    		padding: 10px;
    		border: 1px solid black;
    		border-radius: 10px;
    		font-family: Avenir;
    	}
    	
    	.search-field {
    		width: 500px;
    	}

    	.search-btn {
    		margin-right: 0px;
    		background-color: #FFFAD0;
    	}

    	h2 {
    		text-align: center;
    		margin-top: 100px;
    		font-size: 40px;
    		font-family: Avenir Black;
		}    	

    	.search-result a {
    		font-family: Avenir;
    		text-align: center;
    		text-decoration: none;
    		padding: 10px;
    		display: block;
    		margin: auto;
    		border: 1px solid gray;
    		border-radius: 7px;
    		background-color: #FFFFFF;
    		margin-top: 10px;
    		width: 800px;
    	}
    </style>

</head>
<body>
     <div class="header">
        <form action="/search" method = "post">
            <h1> Simple Search Engine</h1>
            <div class="form-box">
                <input type="text" id="search" name="search" class="search-field" placeholder="search keyword" value="${value}">
                <select name="strategy" id="strategy" class="search-field-strategy">
                  <option value="ANY">Any</option>
                  <option value="ALL">All</option>
                  <option value="NONE">None</option>
                </select>
                <button class="search-btn" type="submit">Search</button>

            </div>

            <div>
            	<h2>Results</h2>
                <div>
                	<#list results as result>
                       <div class = "search-result" target="_blank" rel="noopener noreferrer"><a href="/files?file=${result}">${result}</a></div>
                	</#list>
                </div>
            </div>
        </form>
       </div>
</body>
</html>