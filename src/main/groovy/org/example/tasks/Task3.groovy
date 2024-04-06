package org.example.tasks


import org.example.util.SearchHttp
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Task3 {
    SearchHttp searchHttp

    Task3(){
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
        try {
            Document page = Jsoup.connect(urlTISS()).get()
            Element content = page.select(".internal-link").get(2)
            String url = content.select("a").attr("href")

            Document page2 = searchHttp.searchHttp(url)
            Element content2 = page2.select("#parent-fieldname-text").get(0)
            url = content2.select("a").attr("href")

            searchHttp.download(url, "tabela_de_erros_ANS.xlsx")

        }catch (Exception e) {
            println("Erro ao captar os dados: " + e.getMessage())
        }
    }
}
