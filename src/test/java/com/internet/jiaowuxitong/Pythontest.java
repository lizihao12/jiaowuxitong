package com.internet.jiaowuxitong;

import com.internet.jiaowuxitong.entity.vo.CompetitionInfoVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Pythontest {

        @Test
        public void test() {
            List<CompetitionInfoVo> lists = new ArrayList<>();

            try {
//                //下面这行代码是连接我们的目标站点，并且get到他的静态HTML代码
//                Document document= Jsoup.connect("https://www.saihuan.net/").get();
//                //我们把获取到的document打印一下，看看里面到底是啥？
//                System.out.println(document);
                String url = "https://www.saihuan.net/";
                Document docuemnt = Jsoup.parse(new URL(url), 10000);
                Element content = docuemnt.getElementById("itemContainer");



                String[] string1 = new String[]{};
                String[] string2 = new String[]{};
                String[] string3 = new String[]{};
                ArrayList<String> arrayList1 = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();

                //图
                Elements imgs = content.getElementsByTag("img");
                int a = 1;
                int blog1 = 0;
                int blog2 = 0;
                int blog3 = 0;

                for(Element img : imgs ){
                    if( a%2 != 0){
                        String src = img.attr("src");

                        arrayList1.add(src);
//                        System.out.println(blog1);
//                        blog1++;

                    }

                    a++;
                }
                //标题
                Elements elementscategorys = content.getElementsByClass("category-tag");
                for(Element element : elementscategorys ) {

                    String category = element.text();
//                    string2[blog2] = category;
//                    blog2++;
                    arrayList2.add(category);

                }
                //内容
                Elements elementscontents = content.getElementsByClass("multiline-text-overflow");
                for(Element elementscontent : elementscontents ){

                    String content1 = elementscontent.text();
                    arrayList3.add(content1);
//                    string3[blog3] = content1;
//                    blog3++;

                }
                for(int i=0;i<string1.length;i++){
                    CompetitionInfoVo competitionInfoVo = new CompetitionInfoVo();
                    competitionInfoVo.setImg(arrayList1.get(i));
                    competitionInfoVo.setCategory(arrayList2.get(i));
                    competitionInfoVo.setContent(arrayList3.get(i));
                    lists.add(competitionInfoVo);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }


}
