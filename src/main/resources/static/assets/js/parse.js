///////////////////////// 아파트 매매 정보 /////////////////////////
document.querySelector("#list-btn").addEventListener("click", function () {
  let url =
    "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
  let regCode = getParameter("regCode");
  if (regCode == "") {
    let gugunSel = document.querySelector("#gugun");
    regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
  }
  let yearSel = document.querySelector("#year");
  let year = yearSel[yearSel.selectedIndex].value;
  let monthSel = document.querySelector("#month");
  let month = monthSel[monthSel.selectedIndex].value;
  let dealYM = year + month;
  let queryParams =
    encodeURIComponent("serviceKey") + "=" + "EjuKZsF6ZQLgh7AIGM3ifm1pC2hacR3pZ6gqKPT4ietqs%2Ff8SOYtF7CLvT728KLqSF5HlfUlvRrizYr6dFMfVQ%3D%3D"; /*Service Key*/
  queryParams +=
    "&" +
    encodeURIComponent("LAWD_CD") +
    "=" +
    encodeURIComponent(regCode); /*아파트소재 구군*/
  queryParams +=
    "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM); /*조회년월*/
  queryParams +=
    "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
  queryParams +=
    "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("100"); /*페이지당건수*/

  fetch(`${url}?${queryParams}`)
    .then((response) => response.text())
    .then((data) => makeList(data));
});

function makeList(data) {
  let table = $('#dataTable').DataTable();
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, "application/xml");

  initTable();
  let dong = getParameter("dong");

  let apts = xml.querySelectorAll("item");
  apts.forEach((apt) => {
    let address = apt.querySelector("도로명").textContent;
    let nameTd = apt.querySelector("아파트").textContent;
    let floorTd = apt.querySelector("층").textContent;
    let areaTd = apt.querySelector("전용면적").textContent;
    let dongTd = apt.querySelector("법정동").textContent;
    let priceTd = apt.querySelector("거래금액").textContent + "만원";

    // 일치하는 동만 출력
    if (dong == "" || dong == dongTd.trim()) {
      table.row.add([address, nameTd, floorTd, areaTd, dongTd, priceTd]);
    }
  });

  table.draw();
}

function initTable() {
  $('#dataTable').DataTable().clear();
}

function getParameter(name) {
  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
      results = regex.exec(location.search);
  return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}