<!-- admin_sales.jsp - 매출 - 판매분석 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/soap/resources/tablesorter/jquery-latest.js"></script> 
<script type="text/javascript" src="/soap/resources/tablesorter/jquery.tablesorter.js"></script>
<script src="/soap/resources/js/highcharts.js"></script>
<script src="/soap/resources/js/modules/exporting.js"></script>
<meta charset="utf-8">
	<style type = "text/css">
	
		* { margin: 0px; padding: 0px; }

		#in { width : 1024px; margin : 50px auto; color: #85858d; font-family : "나눔바른고딕", "맑은 고딕"; }
		#in a { text-decoration: underline; text-decoration: none; color:white; }
				
		h2 { margin-top:40px; margin-bottom: 20px; color: #85858D;}
		
		table { width: 100%; padding : 0px; }
		table th
		{
			background-color: #918686; 
			text-align: center; 
			color: white;
			text-style: bold; 
			padding: 10px;
		}
		table tr td
		{
			border-bottom : 1px solid lightgrey;
			text-align : center;
			margin : 0px;
			padding : 10px;
		}
		table tr:nth-child td:first-child { border-left : 1px solid grey; }
		th.header { 
    		background-image: url(/soap/resources/tablesorter/themes/blue/bg.gif); 
    		cursor: pointer; 
    		background-repeat: no-repeat; 
    		background-position: center right; 
    		border-right: 1px solid #dad9c7; 
		} 
		th.headerSortUp { 
   			background-image: url(/soap/resources/tablesorter/themes/blue/asc.gif); 
		} 
		th.headerSortDown { 
   			background-image: url(/soap/resources/tablesorter/themes/blue/desc.gif); 
		} 
		
		#chart_sales { margin: 30px 0; text-align: center; }
		#chart_age { margin: 20px 0; width: 500px; display: inline-block; text-align: center; }
		#chart_gender { margin: 20px 0; width: 500px; display: inline-block; text-align: center; }
	</style>
   </head>
   <body>
	
<!---Start container----------------------------------------------------------------->
<script type="text/javascript">

	var sells_chart_option;
	var member_chart_option;
	
	var sells_chart;
	var mem_age_chart;
	var mem_gen_chart;
	
	var s_proc_url = 'http://localhost:8082/soap/admin/sales_charts.nm';
	var a_proc_url = 'http://localhost:8082/soap/admin/age_charts.nm';
	var g_proc_url = 'http://localhost:8082/soap/admin/gender_charts.nm';

	$(document).ready(function() 
		{ 
			$("#rank_sells").tablesorter(); 
			$.getJSON(s_proc_url, null, function(bddata){
				
				sells_chart_option = {
						
						chart: {
				            type: 'column',
				            renderTo: 'chart_sales'
				        },
				        credits: {
				            enabled: false
				        },
				        title: {
				            text: bddata.title
				        },
				        xAxis: {
				            categories: ['상품'],
				            crosshair: true
				        },
				        yAxis: {
				            min: 0,
				            title: {
				                text: '총 누적 판매량'
				            }
				        },
				        tooltip: {
				            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
				                '<td style="padding:0"><b>{point.y} 개</b></td></tr>',
				            footerFormat: '</table>',
				            shared: false,
				            useHTML: true
				        },
				        plotOptions: {
				            column: {
				                pointPadding: 0.2,
				                borderWidth: 0
				            }
				        },
				        series: [{
				            name: bddata.data[0].name,
				            data: [bddata.data[0].data]
				     	}, {
				            name: bddata.data[1].name,
				            data: [bddata.data[1].data]

				        }, {
				            name: bddata.data[2].name,
				            data: [bddata.data[2].data]
				        }, {
				            name: bddata.data[3].name,
				            data: [bddata.data[3].data]
				        }, {
				            name: bddata.data[4].name,
				            data: [bddata.data[4].data]
				        }]
				};
					
				sells_chart = new Highcharts.Chart(sells_chart_option);
			});
			
			// Load the fonts
			Highcharts.createElement('link', {
			   href: '//fonts.googleapis.com/css?family=Dosis:400,600',
			   rel: 'stylesheet',
			   type: 'text/css'
			}, null, document.getElementsByTagName('head')[0]);

			Highcharts.theme = {
			   colors: ["#7cb5ec", "#f7a35c", "#90ee7e", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
			      "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
			   chart: {
			      backgroundColor: null,
			      style: {
			         fontFamily: "Dosis, sans-serif"
			      }
			   },
			   title: {
			      style: {
			         fontSize: '16px',
			         fontWeight: 'bold',
			         textTransform: 'uppercase'
			      }
			   },
			   tooltip: {
			      borderWidth: 0,
			      backgroundColor: 'rgba(219,219,216,0.8)',
			      shadow: false
			   },
			   legend: {
			      itemStyle: {
			         fontWeight: 'bold',
			         fontSize: '13px'
			      }
			   },
			   xAxis: {
			      gridLineWidth: 1,
			      labels: {
			         style: {
			            fontSize: '12px'
			         }
			      }
			   },
			   yAxis: {
			      minorTickInterval: 'auto',
			      title: {
			         style: {
			            textTransform: 'uppercase'
			         }
			      },
			      labels: {
			         style: {
			            fontSize: '12px'
			         }
			      }
			   },
			   plotOptions: {
			      candlestick: {
			         lineColor: '#404048'
			      }
			   },
			   // General
			   background2: '#F0F0EA'
			};
			// Apply the theme
			Highcharts.setOptions(Highcharts.theme);
			
			$.getJSON(a_proc_url, null, function(bddata){
				member_chart_option = {
						
						 chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: null,
					            plotShadow: false,
					            type: 'pie',
					            renderTo: 'chart_age'
					            
					        },
					        credits: {
					            enabled: false
					        },
					        title: {
					            text: bddata.title
					        },
					        tooltip: {
					            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b><br><b>{point.id}</b> 명'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [{
					            name: 'Percent',
					            colorByPoint: true,
					            data: [{
					            	id: bddata.data[0].amount,
					                name: bddata.data[0].name,
					                y: bddata.data[0].y
					            }, {
					            	id: bddata.data[1].amount,
					                name: bddata.data[1].name,
					                y: bddata.data[1].y,
					            }, {
					            	id: bddata.data[2].amount,
					                name: bddata.data[2].name,
					                y: bddata.data[2].y,
					            }, {
					            	id: bddata.data[3].amount,
					                name: bddata.data[3].name,
					                y: bddata.data[3].y,
					            }]
					        }]
				};
					
				mem_age_chart = new Highcharts.Chart(member_chart_option);
			});
			
			$.getJSON(g_proc_url, null, function(bddata){
				gender_chart_option = {
						
						 chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: null,
					            plotShadow: false,
					            type: 'pie',
					            renderTo: 'chart_gender'
					            
					        },
					        credits: {
					            enabled: false
					        },
					        title: {
					            text: bddata.title
					        },
					        tooltip: {
					            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b><br><b>{point.id}</b> 명'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [{
					            name: 'Percent',
					            colorByPoint: true,
					            data: [{
					            	id: bddata.data[0].amount,
					                name: bddata.data[0].name,
					                y: bddata.data[0].y
					            }, {
					            	id: bddata.data[1].amount,
					                name: bddata.data[1].name,
					                y: bddata.data[1].y,
					            }]
					        }]
				};
					
				mem_gen_chart = new Highcharts.Chart(gender_chart_option);
			});	
		} 
	); 
</script>
    <div id="in">
    	<div id = "stat_product">
		<h2 id = "product_rank"> 판매 상품 순위</h2>
			<table cellspacing="0" id = "rank_sells" class="tablesorter">
				<thead>
				<tr>
					<th>순위</th>
					<th>상품명</th>
					<th>누적 판매 수</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="rank" items="${rank_list}" begin="0" end="4" step="1">
				<tr>
					<td>${rank.rownum}</td>
					<td>${rank.product_name}</td>
					<td>${rank.all_sells}</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<div id = "chart_sales">
			
			</div>
		</div>
		<div id = "stat_member">
			<h2> 고객 분석</h2>
			<div id = "chart_age">
			
			</div>
			<div id = "chart_gender" >
			
			</div>
		</div>	
	</div>
	<!--------------------------------------------------------end container------------->
  </body>

</html>