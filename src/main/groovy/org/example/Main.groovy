package org.example

import org.example.tasks.Task1
import org.example.tasks.Task2
import org.example.tasks.Task3
import org.example.util.SearchHttp
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
class Main{
    static void main(String[] args) {
        def task1 = new Task1()
        def task2 = new Task2()
        def task3 = new Task3()
        task1.init()
        task2.init()
        task3.init()
    }
}

