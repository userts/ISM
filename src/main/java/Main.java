import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * Created by tosz on 2015-01-22.
 */
public class Main {


    public static void main(String[] args) {

        List<String> myFounds = new ArrayList<>();

        get("/myFounds", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return myFounds.stream().reduce((e1, e2) -> e1 + " " + e2);
            }
        });

        get("/addFounds/:type", (req, res) -> {
            myFounds.add(req.params("type"));
            res.redirect("/myFounds");
            return (null);
        });

        get("/investment-simulator", (req, res) ->
                        "<a href=http://localhost:4567/funds>rozpocznij symulację</a>" + " | " +
                        "<h3>Symulator oszczędzania w TFI pomoże Ci w: </h3></br>" +
                                "- zrozumieniu działania funduszy inwestycyjnych </br>" +
                                "- ułatwi wybór odpowiedniego funduszu.</br>"

        );

        get("/funds", (req, res) ->
                        "<a href=http://localhost:4567/investment-simulator>zakończ symulację</a>" + " | " +
                                "<a href=http://localhost:4567/myFounds>moje fundusze</a></br>" +
                                "<h3>TFI oferuje pięć funduszy:</h3></br>" +
                                "- rynku pieniężnego, A i B " +
                                "<a href=http://localhost:4567/founds/money-market>kup jednostki</a></br>" +
                                "- obligacji, A i B " +
                                "<a href=http://localhost:4567/founds/bond>kup jednostki</a></br>" +
                                "- stabilnego wzrostu, A i B " +
                                "<a href=http://localhost:4567/founds/stable-growth>kup jednostki</a></br>" +
                                "- zrównoważony, A i B " +
                                "<a href=http://localhost:4567/founds/balanced>kup jednostki</a></br>" +
                                "- akcji, A i B " +
                                "<a href=http://localhost:4567/founds/stock>kup jednostki</a>"
        );

        get("/founds/money-market", (req, res) ->
                        "<a href=http://localhost:4567/funds>powrót</a>" + " | " +
                                "<h3>Fundusz ma dwa typy jednostek: A i B. </h3></br>" +
                                "- zkup jednostki typu A obarczony jest prowizją 2% pobieraną przy zakupie, prowizji przy sprzedaży nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/funduszRynkuPienieznego-jednostkaTypA; >kupuję jednostkę</a></br>" +
                                "- zakup jednostki typu B także obarczony jest prowizją 2%, ale pobieraną przy sprzedaży, a prowizji przy zakupie nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/funduszRynkuPienieznego-jednostkaTypB; >kupuję jednostkę</a></br>"

        );

        get("/founds/bond", (req, res) ->
                        "<a href=http://localhost:4567/funds>powrót</a></br>" +
                                "<b>Fundusz ma dwa typy jednostek: A i B. </b></br>" +
                                "- zkup jednostki typu A obarczony jest prowizją 2% pobieraną przy zakupie, prowizji przy sprzedaży nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-obligacji-jednostkaTypA; >kupuję jednostkę</a></br>" +
                                "- zakup jednostki typu B także obarczony jest prowizją 2%, ale pobieraną przy sprzedaży, a prowizji przy zakupie nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-obligacji-jednostkaTypB; >kupuję jednostkę</a></br>"

        );

        get("/founds/stable-growth", (req, res) ->
                        "<a href=http://localhost:4567/funds>powrót</a></br>" +
                                "<b>Fundusz ma dwa typy jednostek: A i B. </b></br>" +
                                "- zkup jednostki typu A obarczony jest prowizją 2% pobieraną przy zakupie, prowizji przy sprzedaży nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-stabilnego-wzrostu-jednostkaTypA; >kupuję jednostkę</a></br>" +
                                "- zakup jednostki typu B także obarczony jest prowizją 2%, ale pobieraną przy sprzedaży, a prowizji przy zakupie nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-stabilnego-wzrostu-100-jednostkaTypB; >kupuję jednostkę</a></br>"

        );

        get("/founds/balanced", (req, res) ->
                        "<a href=http://localhost:4567/funds>powrót</a></br>" +
                                "<b>Fundusz ma dwa typy jednostek: A i B. </b></br>" +
                                "- zkup jednostki typu A obarczony jest prowizją 2% pobieraną przy zakupie, prowizji przy sprzedaży nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-zrownowazony-jednostkaTypA; >kupuję jednostkę</a></br>" +
                                "- zakup jednostki typu B także obarczony jest prowizją 2%, ale pobieraną przy sprzedaży, a prowizji przy zakupie nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-zrownowazony-jednostkaTypB; >kupuję jednostkę</a></br>"

        );

        get("/founds/stock", (req, res) ->
                        "<a href=http://localhost:4567/funds>powrót</a></br>" +
                                "<b>Fundusz ma dwa typy jednostek: A i B. </b></br>" +
                                "- zkup jednostki typu A obarczony jest prowizją 2% pobieraną przy zakupie, prowizji przy sprzedaży nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-akcji-jednostkaTypA; >kupuję jednostkę</a></br>" +
                                "- zakup jednostki typu B także obarczony jest prowizją 2%, ale pobieraną przy sprzedaży, a prowizji przy zakupie nie pobiera się. " +
                                "<a href=http://localhost:4567/addFounds/fundusz-akcji-jednostkaTypB; >kupuję jednostkę</a></br>"

        );




    }

}
