<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grid Tests</title>

<link rel="stylesheet" src="/css/jquery-ui-1.12.1.min">
<link rel="stylesheet" src="/css/jqGrid/ui.jqgrid.css">
<link rel="stylesheet" src="/css/jqGrid/ui.multiselect.css">

<script src="/js/jqGrid/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="/js/jqGrid/i18n/grid.locale-kr.js" type="text/javascript"></script>
<script src="/js/jqGrid/jquery.jqGrid.min.js" type="text/javascript"></script>

<script type="text/javascript"></script>
function search() {
    var jsonObj = {};
    
    if($("#selectId").val() != "C") {
        jsonObj.serviceImplYn = $("#selectId").val();
    }
    
    alert(JSON.stringify(jsonObj));
    
    $("#jqGrid").setGridParam({
        datatype : "json",
        postData : {"param" : JSON.stringify(jsonObj)},
        loadComplete : function(data) {
            
        },
        
        gridComplete : function() {
            
        }
    }).trigger("reloadGrid");
}
</script>

</head>
<body>

<div>
 <select id="selectId">
  <option value="">All</option>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option> 
</select>    
 <span><a href="#" onclick="javascript:search();">Search</a></span>
</div>

	<div class="row"> 
    <div>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>
</div>


</body>
<script type="text/javascript"></script>
$(document).ready(function() {
    
    var cnames = ['아이디','이름','전화번호','주소','기타','성별코드'];
 
    $("#jqGrid").jqGrid({
        
        url: "jqgridStartMain.do",
        datatype: "local",
        colNames: cnames,
        colModel:[
                  
                  {name:'seq',index:'seq', width:55, key:true, align:"center"},
                  {name:'name',index:'name', width:100, align:"center"},
                  {name:'phone',index:'phone', width:100},
                  {name:'address',index:'address', width:100},
                  {name:'etcc',index:'etcc', width:100},
                  {name:'gender',index:'gender', width:100}
                  
                  ],
                  
        height: 480,
        rowNum: 10,
        rowList: [10,20,30],
        pager: '#jqGridPager',
        rownumbers  : true,                     
        ondblClickRow : function(rowId, iRow, iCol, e) {
 
            if(iCol == 1) {
                alert(rowId+" 째줄 입니다.");
            }
        },
        
        viewrecords : true,
        caption:"JQGRID TABLE"
        });
    });
    </script>
</html>