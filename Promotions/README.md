# **Promotions Services Automation**

#### **To Run Test Cases**
```mvn clean integration-test```

| Command Prompt Options                   |
|------------------------------------------|
| ```-DcucumberTags="@smoke"```              |
| ```-DbaseApiUri="https://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1"``` |

#### **Example**
```mvn clean integration-test -DcucumberTags="@smoke" -DbaseApiUri="https://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1"```

#### **To Run Allure Reports**
```mvn allure:serve```