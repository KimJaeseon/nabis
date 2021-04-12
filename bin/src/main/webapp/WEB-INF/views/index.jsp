<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--link rel="stylesheet" th:href="@{/css/board.css}"-->
<link rel="stylesheet" src="/css/jqGrid/ui.jqgiboard.css">

<script src="/js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="/js/jqGrid/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
// We use a document ready jquery function.
$.(document).ready(function(){
$.("#list2").jqGrid({
    // the url parameter tells from where to get the data from server
    // adding ?nd='+new Date().getTime() prevent IE caching
    url:'example.php?nd='+new Date().getTime(),
    // datatype parameter defines the format of data returned from the server
    // in this case we use a JSON data
    datatype: "json",
    // colNames parameter is a array in which we describe the names
    // in the columns. This is the text that apper in the head of the grid.
    colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
    // colModel array describes the model of the column.
    // name is the name of the column,
    // index is the name passed to the server to sort data
    // note that we can pass here nubers too.
    // width is the width of the column
    // align is the align of the column (default is left)
    // sortable defines if this column can be sorted (default true)
    colModel:[
        {name:'id',index:'id', width:55},
        {name:'invdate',index:'invdate', width:90},
    	{name:'name',index:'name asc, invdate', width:100},
        {name:'amount',index:'amount', width:80, align:"right"},
        {name:'tax',index:'tax', width:80, align:"right"},		
        {name:'total',index:'total', width:80,align:"right"},		
        {name:'note',index:'note', width:150, sortable:false}		
    ],
    // pager parameter define that we want to use a pager bar
    // in this case this must be a valid html element.
    // note that the pager can have a position where you want
    pager: $.('#pager2'),
    // rowNum parameter describes how many records we want to
    // view in the grid. We use this in example.php to return
    // the needed data.
    rowNum:10,
    // rowList parameter construct a select box element in the pager
    //in wich we can change the number of the visible rows
    rowList:[10,20,30],
    // path to mage location needed for the grid
    imgpath: 'themes/sand/images',
    // sortname sets the initial sorting column. Can be a name or number.
    // this parameter is added to the url
    sortname: 'id',
    //viewrecords defines the view the total records from the query in the pager
    //bar. The related tag is: records in xml or json definitions.
    viewrecords: true,
    //sets the sorting order. Default is asc. This parameter is added to the url
    sortorder: "desc",
    caption: "Demo"
});
});
</script>
</head>
<body>
	<table id="list2" class="scroll" cellpadding="0" cellspacing="0"></table>

<!-- pager definition. class scroll tels that we want to use the same theme as grid -->
<div id="pager2" class="scroll" style="text-align:center;"></div>
</body>
</body>
</html>