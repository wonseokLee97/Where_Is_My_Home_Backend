var myLatLng = new kakao.maps.LatLng(33.450701, 126.570667); //지도의 중심좌표.

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: myLatLng, // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

var marker = new kakao.maps.Marker({  
  map: map, 
  position: map.getCenter() 
}); 

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
  // GeoLocation을 이용해서 접속 위치를 얻어옵니다
  navigator.geolocation.getCurrentPosition(function(position) {
      
      var lat = position.coords.latitude, // 위도
          lon = position.coords.longitude; // 경도
      
    var coords = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
    marker.setPosition(coords);
     // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(coords);     
  });
  
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
  
  var coords = new kakao.maps.LatLng(33.450701, 126.570667);
  marker.setPosition(coords);
  // 지도 중심좌표를 접속위치로 변경합니다
  map.setCenter(coords);     
}

function setMarker(...args) {
  var lng = 126.570667;
  var lat = 33.450701;

  if (arguments.length == 1) { // 주소로 좌표를 검색
    geocoder.addressSearch(address, function (result, status) {
	    if (status === kakao.maps.services.Status.OK) {
	    	lng = result[0].x;
	    	lat = result[0].y; 
	    }
    });

  } else if (arguments.length == 2) {
    	lng = args[0];
    	lat = args[1];
	}

  var coords = new kakao.maps.LatLng(lat, lng);
  marker.setPosition(coords);
  // 지도 중심좌표를 접속위치로 변경
  map.setCenter(coords);   

  window.scrollTo(0, 0);
}
