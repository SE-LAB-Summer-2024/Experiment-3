<div dir="rtl">

به نام خدا

# توسعه آزمون‌رانه و پوشش آزمون (Test-driven Development and Test Coverage)


## استفاده از TDD
1.  در قسمت اول از پیدا کردن عیوب موجود در کد اصلی تست ای برای تابع lendBook نوشتیم که این تست در مسیر `src/test/classes/LibraryTest/` قرار دارد. در زیر تصاویر مربوط به تست نوشته شده و کد اصلاح شده را برای پاس کردن این تست داریم.

![](images/lendBookTest.png "تست نوشته شده برای تابع lendBook")

![](images/lendBookWrongResult.png "نتیجه اجرای تست برای تابع lendBook")

![](images/lendBookFixedCode.png "کد اصلاح شده تابع lendBook")

![](images/lendBookCorrectResult.png "نتیجه اجرای تست برای تابع lendBook پس از اصلاح")

####  ایراد موجود چک نکردن رجیستر بودن یا نبودن دانش آموز بود.

2. در قسمت دوم از پیدا کردن عیوب موجود در کد اصلی تست ای برای تابع returnBook نوشتیم که این تست در مسیر `src/test/classes/LibraryTest/` قرار دارد. در زیر تصاویر مربوط به تست نوشته شده و کد اصلاح شده را برای پاس کردن این تست داریم.

![](images/returnBookTest.png "تست نوشته شده برای تابع returnBook")

![](images/returnBookWrongResult.png "نتیجه اجرای تست برای تابع returnBook")

![](images/returnBookFixedCode.png "کد اصلاح شده تابع returnBook")

![](images/returnBookCorrectResult.png "نتیجه اجرای تست برای تابع returnBook پس از اصلاح")

####  ایراد موجود عدم حذف کتاب پس داده شده از لیست کتاب های دانش آموز بود.



3. در فایل
`Library.java`
دو تابع جستجو وجود دارد که باید با توجه به کامنت‌های آن‌ها و با استفاده از روش 
TDD
کاملشان کنید. برای این کار ابتدا تعدادی تست بنویسید که نیازمندی‌های این ۲ تابع را پوشش دهند، سپس ۲ تابع را به شکلی کامل کنید که همه آن‌ها پاس شوند.

گزارش مختصری از مراحل انجام آزمایش را در فایل README.md پروژه بنویسید.




## پرسش‌ها
پاسخ پرسش‌های زیر را داخل فایل README پروژه بنویسید:


۱. روش
TDD
را با روش تست کردن سنتی که در آن بعد از نوشتن برنامه، تست‌ها نوشته می‌شوند، از نظر نوع پروژه‌هایی که هر یک برای آن‌ها مناسب هست، مقایسه کنید.


۲. در فرایند ایجاد نرم‌افزار هم تیم ایجاد
(Development Team)
و هم تیم تضمین کیفیت
(QA Team)
وظیفه تست نرم‌افزار را برعهده دارند.
هر کدام از این تیم‌ها بیش‌تر با کدام دسته از انواع تست سروکار دارد؟ چرا؟ انواع تست ذکر شده را به طور مختصر شرح دهید.


۳. روالی ‬‫را که‬ ‫برای‬ ‫پروژه‬ ‫‪json-simle‬‬ ‫ارائه‬ ‫شد‬،‬ ‫برای‬ پروژه ای که بر روی آن مشغول هستید هم‬ ‫انجام‬ ‫دهید.
برای ‫به‬ ‫دست‬‫‌آوردن‬ ‫اعداد‬ ‫پوشش‬ ‫آزمون‬ ‫کافی‬ ‫است‬ ‫بر‬ ‫روی‬ ‫پکیج‬ ‫‪java‬‬ ‫در‬ ‫مسیر‬ ‫‪test‬‬ ‫کلیک‬ ‫راست‬ ‫کرده‬ ‫و‬ ‫گزینه ‬‫‪coverage‬‬ ‫‪with‬‬ ‫‪Tests‬‬ ‫‪All‬‬ ‫‪Run‬‬ ‫را‬ ‫انتخاب‬ ‫کنید‬ ‫(نیازی‬ ‫به‬ ‫اجرای‬ ‫عادی‬ ‫پروژه‬ ‫نیست)‪.‬‬‫

این کار را انجام دادیم و نتیجه اولیه به این صورت بود :

![](images/FirstCoverage.png)

۴. با افزودن بخش‌هایی به کد تست، اعداد پوشش آزمون را در مورد تمامی کلاس‌های موجود در برنامه بهبود دهید. درصد افزایش اعداد پوشش آزمون مهم نیست ولی بخش‌هایی که به کد تست اضافه می‌شوند باید معنادار باشند و صرفاً یک فراخوانی ساده کلاس یا متد، بدون استفاده در بخش‌های دیگر کد کافی نیست. 

تکه کد زیر را اضافه کردیم :‌
```
@Test
    void displayBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        library.setBooks(books);

        library.displayBooks();

        String expectedOutput = "Available books in library:\n"
                + "Book 1 by Author 1\n"
                + "Book 2 by Author 2";
        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void displayStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Student 1", 1));
        students.add(new Student("Student 2", 2));
        library.setStudents(students);

        library.displayStudents();

        String expectedOutput = "Registered students:\n"
                + "Student 1|1\n"
                + "Student 2|2";

        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }
```

و در نهایت همانطور که مشاهده می کنید درصد های method coverage افزایش یافت.

![](images/LastCoverage.png)

