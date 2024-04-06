package org.example.tasks

import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download
import org.example.util.SearchHttp
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Task1 {
    SearchHttp searchHttp
    Task1(){
        searchHttp =  new SearchHttp()
    }
    String urlTISS() {
        Document page = searchHttp.searchHttp("https://www.gov.br/ans/pt-br")
        Element content = page.getElementById("ce89116a-3e62-47ac-9325-ebec8ea95473")
        String url = content.getElementsByTag("a").attr("href")

        Document page2 = searchHttp.searchHttp(url)
        Element content2 = page2.getElementsByClass("govbr-card-content").first()
        return content2.getElementsByTag("a").attr("href")
    }

    void init() {
        Document page = searchHttp.searchHttp(urlTISS())
        Element content = page.getElementsByClass("internal-link").first()
        String url = content.getElementsByTag("a").attr("href")

        Document page2 = searchHttp.searchHttp(url)
        Element table = page2.getElementsByTag("tbody").first().getElementsByTag("tr").last()
        url = table.lastElementChild().firstElementChild().getElementsByTag("a").attr("href")

        searchHttp.download(url, "Documento_do_TISS.zip")

    }
}
