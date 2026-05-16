# 🛒 Hybrid Test Automation Framework
### End-to-End Web Automation for E-Commerce Application

![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.44.0-green?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.12.0-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![Apache POI](https://img.shields.io/badge/Apache_POI-Excel-purple)

---

## 📌 Project Overview

This project is a **Hybrid Test Automation Framework** built using Java, Selenium WebDriver, and TestNG to automate the testing of an e-commerce web application — [demowebshop.tricentis.com](https://demowebshop.tricentis.com/).

The framework follows the **Page Object Model (POM)** design pattern and supports:
- Data-Driven Testing via Excel (Apache POI)
- Cross-browser execution
- Reusable components
- Structured reporting

---

## 🧰 Technologies Used

| Technology     | Purpose                        |
|----------------|-------------------------------|
| Java 21        | Programming Language           |
| Selenium 4.44  | Browser Automation             |
| TestNG 7.12    | Test Execution Framework       |
| Maven          | Build & Dependency Management  |
| Apache POI     | Excel Data Reading             |
| Git & GitHub   | Version Control                |

---

## 📁 Project Structure

```
Automation_Project/
├── src/test/java
│   ├── org.base.qa
│   │   └── BaseClass.java           # Loads config, initializes driver
│   ├── org.pages.qa
│   │   ├── LoginPage.java
│   │   ├── ProductDetailsPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   ├── org.tests.qa
│   │   ├── LoginTest.java
│   │   ├── SearchAndCartTest.java
│   │   └── CheckoutTest.java
│   └── org.utilities.qa
│       ├── BrowserManage.java       # @BeforeMethod / @AfterMethod
│       └── ExcelUtil.java           # Apache POI Excel reader
├── src/test/resources
│   ├── Config
│   │   └── Application.properties  # Browser config
│   └── TestData
│       └── TestData.xlsx            # Test credentials
├── pom.xml
└── testng.xml
```

---

## ⚙️ Configuration

Edit `src/test/resources/Config/Application.properties`:

```properties
Browser=Chrome
```

Supported values: `Chrome`, `Edge`

---

## 📊 Test Data (Excel)

Located at `src/test/resources/TestData/TestData.xlsx`

| Row | Username            | Password        |
|-----|---------------------|-----------------|
| 1   | sway1@gmail.com     | r4TqCZPVFCB3w#  |
| 2   | invalid_user        | wrong123        |

---

## 🧪 Test Cases

### Login Tests (`LoginTest.java`)
| Test | Description |
|------|-------------|
| `validLoginTest` | Login with valid credentials — asserts redirect to home page |
| `invalidLoginTest` | Login with invalid credentials — asserts error shown |
| `blankLoginTest` | Login with empty fields — asserts validation message |

### Search & Cart Tests (`SearchAndCartTest.java`)
| Test | Description |
|------|-------------|
| `searchProductTest` | Search for a product and verify result title |
| `addProductToCartTest` | Add product to cart and verify success message |
| `verifyCartItemTest` | Navigate to cart and verify product name |

### Checkout Tests (`CheckoutTest.java`)
| Test | Description |
|------|-------------|
| `enterShippingDetailsTest` | Fill billing/shipping form as guest |
| `placeOrderTest` | Complete full checkout flow |
| `verifyOrderConfirmationTest` | Assert order confirmation message |

---

## 🚀 Execution Steps

### 1. Clone the Repository
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Run All Tests via TestNG XML
```bash
mvn test
```
Or in Eclipse/IntelliJ:
> Right-click `testng.xml` → **Run As** → **TestNG Suite**

### 4. Run a Specific Test Class
```bash
mvn test -Dtest=LoginTest
mvn test -Dtest=SearchAndCartTest
mvn test -Dtest=CheckoutTest
```

### 5. View Reports
After execution, open:
```
test-output/index.html
```

---

## 🏗️ Framework Architecture

```
┌─────────────────────────────────┐
│          Test Layer             │  ← LoginTest, SearchAndCartTest, CheckoutTest
├─────────────────────────────────┤
│          Page Layer             │  ← LoginPage, ProductDetailsPage, CartPage, CheckoutPage
├─────────────────────────────────┤
│         Utility Layer           │  ← BrowserManage, ExcelUtil, BaseClass
├─────────────────────────────────┤
│          Resources              │  ← Application.properties, TestData.xlsx, testng.xml
└─────────────────────────────────┘
```

---

## 🔑 Key Design Decisions

- **Page Object Model** — each page has its own class with `@FindBy` locators and action methods
- **PageFactory** — all page classes use `PageFactory.initElements()` for element initialization
- **Instance driver** — `WebDriver driver` is an instance variable (not static) to avoid session conflicts across tests
- **Explicit Waits** — `WebDriverWait` used only where page transitions require it
- **Data-Driven** — credentials and test data read from Excel using Apache POI

---

## ⚠️ Known Limitations

- Demowebshop is a public demo site — occasional downtime may cause test failures
- Guest checkout uses a fixed email; repeated runs may show "email already used" errors
- CDP version mismatch warning (Chrome 148 vs Selenium 4.44) is cosmetic and does not affect test execution

---

## 👤 Author

**Swayam Shivankar**
Automation Test Engineer | Java + Selenium + TestNG

---

## 📄 License

This project is for educational purposes as part of an Automation Testing assignment.
