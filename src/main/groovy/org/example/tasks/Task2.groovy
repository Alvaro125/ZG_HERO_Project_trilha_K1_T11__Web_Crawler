package org.example.tasks


import org.example.util.SearchHttp
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Task2 {
    SearchHttp searchHttp

    Task2(){
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
            Element content = page.select(".internal-link").get(1)
            String url = content.attr("href")

            Document page2 = Jsoup.connect(url).get()
            Element content2 = page2.select("tbody").first()
            Elements listTr = content2.select("tr")

            List<List<String>> info = []

            info.add(["Competência", "Publicação", "Início de Vigência"])

            listTr.each { tr ->
                Elements list = tr.select("td")
                String competence = list.get(0).text()

                List<String> competenceSplit = competence.split("/")
                Integer year = Integer.parseInt(competenceSplit[1])

                if (year >= 2016) {
                    String publication = list.get(1).text()
                    String startTerm = list.get(2).text()
                    info.add([competence,publication,startTerm])
                }
            }

            searchHttp.createFile(informacoes, "./Downloads/historico_versoes_TISS.csv")
        } catch (Exception e) {
            println("Erro ao coletar informações: ${e.getMessage()}")
        }
    }
}
