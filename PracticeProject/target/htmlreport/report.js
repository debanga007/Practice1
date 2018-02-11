$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTest.feature");
formatter.feature({
  "line": 1,
  "name": "Test Google Search",
  "description": "",
  "id": "test-google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Search Google with your name",
  "description": "",
  "id": "test-google-search;search-google-with-your-name",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@google"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open Google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I type name in Search box",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click on search",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should see matching search results",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "FirstTest.method1()"
});
formatter.result({
  "duration": 7164244820,
  "status": "passed"
});
formatter.match({
  "location": "FirstTest.i_type_name_in_Search_box()"
});
formatter.result({
  "duration": 203439247,
  "status": "passed"
});
formatter.match({
  "location": "FirstTest.i_click_on_search()"
});
formatter.result({
  "duration": 1101330852,
  "status": "passed"
});
formatter.match({
  "location": "FirstTest.i_should_see_matching_search_results()"
});
formatter.result({
  "duration": 122511270,
  "status": "passed"
});
formatter.match({
  "location": "FirstTest.i_close_the_browser()"
});
formatter.result({
  "duration": 3335419778,
  "status": "passed"
});
});