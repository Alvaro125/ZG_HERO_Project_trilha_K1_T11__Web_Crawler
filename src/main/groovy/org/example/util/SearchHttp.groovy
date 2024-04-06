package org.example.util

import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download
import org.jsoup.nodes.Document

class SearchHttp {
    Document searchHttp(String uri){
        return HttpBuilder.configure {
            request.uri = uri
        }.get()
    }
    void download(String url, String name) {

        File directory = new File("./Downloads")
        directory.mkdirs()
        File path = new File(directory, name)

        HttpBuilder.configure {
            request.uri = url
        }.get { Download.toFile(delegate, path)}
    }

    void createFile(List<List<String>> data, String path ) {

        try {
            File file = new File(path)
            if (file.exists()) {
                file.delete()
            }
            file.createNewFile()
            file.withWriter { writer ->
                data.each { info ->
                    writer.writeLine(info.join(","))
                }
            }
            println("Arquivo salvo em ${path}")
        } catch (Exception e) {
            println("Erro ao criar arquivo: ${e.getMessage()}")
        }
    }
}
