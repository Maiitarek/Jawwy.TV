# Jawwy.TV Test Automation Framework

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.java.com)
[![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)](https://selenium.dev)
[![Appium](https://img.shields.io/badge/Appium-662D91?style=flat)](https://appium.io)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?style=flat&logo=cucumber&logoColor=white)](https://cucumber.io)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)](https://maven.apache.org)
[![CI](https://img.shields.io/badge/CI-GitHub%20Actions-2088FF?style=flat&logo=githubactions&logoColor=white)](https://github.com/Maiitarek/Jawwy.TV/actions)

End-to-end test automation framework for **Jawwy.TV** — a Vodafone/STC streaming platform operating across the Middle East. The framework covers web UI and Android mobile testing using a BDD approach with Cucumber/Gherkin, built on top of Selenium WebDriver and Appium.

---

## Table of contents

- [Overview](#overview)
- [Tech stack](#tech-stack)
- [Framework architecture](#framework-architecture)
- [Folder structure](#folder-structure)
- [Prerequisites](#prerequisites)
- [How to run](#how-to-run)
- [Test reporting](#test-reporting)
- [CI/CD](#cicd)

---

## Overview

Jawwy.TV is a subscription-based video streaming service. This framework validates core user journeys including:

- User authentication (login, registration, password reset)
- Content browsing and search
- Video playback on web and Android
- Subscription and payment flows
- Account management

The framework is designed to run both **web** (Selenium) and **mobile** (Appium) scenarios from the same BDD feature files, with driver management abstracted behind a factory pattern.

---

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 11+ |
| Web automation | Selenium WebDriver 4.x |
| Mobile automation | Appium 2.x |
| BDD framework | Cucumber 7.x + Gherkin |
| Test runner | TestNG |
| Build tool | Maven |
| Mobile emulator | Genymotion / Android Studio AVD |
| Reporting | Cucumber HTML reports |
| Version control | Git / GitHub |

---

## Framework architecture

```
┌─────────────────────────────────────────────────────┐
│                   Feature Files (.feature)           │
│              (Gherkin BDD scenarios)                 │
└──────────────────────┬──────────────────────────────┘
                       │
┌──────────────────────▼──────────────────────────────┐
│                  Step Definitions                    │
│         (maps Gherkin steps to Java methods)         │
└──────────┬───────────────────────────┬──────────────┘
           │                           │
┌──────────▼──────────┐   ┌────────────▼──────────────┐
│    Page Objects     │   │      Driver Factory        │
│  (web UI actions)   │   │  (Selenium / Appium init)  │
└──────────┬──────────┘   └────────────┬──────────────┘
           │                           │
┌──────────▼───────────────────────────▼──────────────┐
│                  Base Test / Hooks                   │
│         (setup, teardown, screenshot on fail)        │
└─────────────────────────────────────────────────────┘
```

**Key design decisions:**
- **Page Object Model (POM)** — each screen has its own class, keeping test logic separate from UI selectors
- **Driver Factory** — single entry point for WebDriver and AppiumDriver instantiation, supports parallel execution
- **BDD with Cucumber** — scenarios written in plain English, readable by non-technical stakeholders
- **Hooks** — `@Before` / `@After` hooks handle driver lifecycle and capture screenshots on test failure

---

## Folder structure

```
Jawwy.TV/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/              # Page Object classes (web + mobile)
│       │   ├── stepDefinitions/    # Cucumber step definition classes
│       │   ├── hooks/              # Before/After hooks, screenshot capture
│       │   ├── driverFactory/      # WebDriver & AppiumDriver factory
│       │   └── utils/              # Helpers: config reader, wait utils
│       └── resources/
│           ├── features/           # Gherkin .feature files
│           └── config.properties   # Environment config (URLs, timeouts)
├── Tools/                          # ChromeDriver, AppiumDriver binaries
├── pom.xml                         # Maven dependencies and build config
└── README.md
```

---

## Prerequisites

| Requirement | Version |
|---|---|
| Java JDK | 11 or higher |
| Maven | 3.6+ |
| Chrome browser | Latest |
| ChromeDriver | Matching Chrome version |
| Appium Server | 2.x (for mobile tests) |
| Android SDK / Genymotion | For mobile emulation |
| Node.js | 16+ (required by Appium) |

---

## How to run

**Clone the repository**
```bash
git clone https://github.com/Maiitarek/Jawwy.TV.git
cd Jawwy.TV
```

**Run all tests**
```bash
mvn clean test
```

**Run web tests only**
```bash
mvn clean test -Dcucumber.filter.tags="@web"
```

**Run mobile tests only**
```bash
mvn clean test -Dcucumber.filter.tags="@mobile"
```

**Run a specific feature**
```bash
mvn clean test -Dcucumber.features="src/test/resources/features/login.feature"
```

> **Note:** For mobile tests, start the Appium server first:
> ```bash
> appium --address 127.0.0.1 --port 4723
> ```

---

## Test reporting

After a test run, Cucumber generates an HTML report at:
```
target/cucumber-reports/cucumber.html
```

Open it in any browser to view:
- Scenario pass/fail breakdown
- Step-by-step execution details
- Screenshots attached to failed steps

---

## CI/CD

This repository uses GitHub Actions for continuous integration. Tests run automatically on every push to `main` and on pull requests.

See [`.github/workflows/test.yml`](.github/workflows/test.yml) for the pipeline configuration.

---

## Author

**Mai Ibrahim** — Senior SDET / QA Engineer  
[LinkedIn](https://www.linkedin.com/in/mai-tarek/) · [GitHub](https://github.com/maiitarek)
