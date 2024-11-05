package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import org.example.Combo.combo;

/*
 * Sukurkite žaidimą, kuriame žaidėjo personažas kovoja „akmuo-popierius-žirklės“ principu prieš kompiuterio personažą arba kitą žaidėją. Žaidimas yra paįvairinamas tuo, kad jeigu žaidėjo arba kompiuterio panaudotos trys atakos atitinka kurią nors programoje išsaugotą kombinaciją, tai yra atliekama papildoma ataka. Kombinacijas galima suprasti kaip muštynių žaidimuose (pvz.: „Mortal Kombat“, „Street Fighter“) naudojamas combo atakas.

Užduoties kokybė priklauso ir nuo studento fantazijos besišypsantis

Programoje turi būti realizuota eilės, steko ir vienakrypčio tiesinio sąrašo duomenų struktūros (būtina naudoti bibliotekas).

Programos vartotojas gali (2 balai):

    Žaisti:
        pasirinkti, kiek bus žaidėjų, (0,2 balo) - Taip
        pasirinkti norimą ataką, (0,3 balo) - Taip
        nutraukti žaidimą (grįžtama į meniu), (0,2 balo) - Ne
    Nustatymai:
        pakeisti nustatymus, bent 3 parinktys, (0,6 balo) - 1 pariktis kolkas
    Peržiūrėti kovų istoriją (kas su kuo žaidė ir kas laimėjo – istorija saugoma vienakrypčiame tiesiniame sąraše), (0,5 balo) -TAIP
    išeiti iš žaidimo. (0,2 balo) - Taip

Nematomos operacijos ir funkcionalumai (5,5 balai):

    galimos atakų kombinacijos laikomos dokumente (.json formatas), (0,5 balo) - TAIP
    realizuotos trijų tipų atakos ir jų veiksmingumas (akmuo nugali žirkles, žirklės nugali popierių ir pan.), (0,5 balo) - TAIP
    combo atakų atlikimas, skirtingų galimų kombinacijų turi būti bent 3; žaidėjo pasirinktoms atakoms kaupti naudojama eilės duomenų struktūra; jeigu surenkama combo ataka, atliekama papildoma ataka (padaroma papildomai žalos); jeigu žaidėjas gavo žalą combo rinkimo metu – combo atakos rinkimas nutrūksta, (1 balas) - Taip (reikia testuot.)
    kartą per kovą žaidėjas gali atlikti UNDO veiksmą – gįžti į kovos stadiją vienu, dviem arba trimis žingsniais atgal; tam kovos eiga yra kaupiama steke, (1 balas) - Taip
    kovų istorija yra saugoma atskirame .json dokumente, (0,5 balo) - TAIP
    galimybė lošti vienam arba dviese, (1 balas) - NE
    atsitiktiniu būdu parenka kompiuterio žaidėjo ataką (papildomi balai, jeigu sugalvosite, kad kompiuteris parinktų atakas pagal žaidėjo atakų istoriją – simple AI), (0,5 balo)
    žaidėjo ir kompiuterio žaidėjo gyvybių taškai ir jų mažėjimas, (0,3 balo) - TAIP
    žaidimo pabaiga, skelbiamas nugalėtojas. (0,2 balo) - TAIP

UI (1 balas):

    žaidimo metu visada matomos valdymas ir žaidėjų gyvybės, (0,5 balo) - Taip
    galima aiškiai suprasti, kas vyksta: kokios parinktos buvo kiekvieno žaidėjo atakos, ar įvyko combo ataka, kokios atakos buvo pasirinktos žaidėjų, kuri ataka laimėjo ir kiek žalos padarė. (0,5 balo) - TAIP

Duomenų struktūrų elementai (1,5 balo):

    žaidėjų ir kompiuterio atakų pasirinkimai,
    žaidimo eigos informacija,
    kovų istorija: kas su kuo žaidė ir kas laimėjo.

Dokumentai: galimos kombinacijos ir kovų istorija yra saugoma json dokumentuose.
Galimi papildomi balai už unikalius sprendimus, stilistiką, DI.
 * 
 * 
 */



public class Main {
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        Menu menu = new Menu();
        LinkedList<History> history= null; 
        LinkedList<combo> Combos = null;
        try (FileReader reader = new FileReader("src/main/java/org/example/Json/combos.json")) {

            Type comboListType = new TypeToken<List<combo>>() {
            }.getType();

            List<combo> tempCombos = gson.fromJson(reader, comboListType);
            Combos = new LinkedList<>(tempCombos);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader("src/main/java/org/example/Json/combos.json")) {

            Type comboListType = new TypeToken<List<combo>>() {
            }.getType();

            List<combo> tempCombos = gson.fromJson(reader, comboListType);
            Combos = new LinkedList<>(tempCombos);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }

        try(FileReader reader = new FileReader("src/main/java/org/example/Json/history.json")){
           Type historyListType = new TypeToken<List<History>>() {
            }.getType();
            List<History> temphistories = gson.fromJson(reader, historyListType);
            if(temphistories == null){
                history = new LinkedList<>();  
            }
            else{
                history = new LinkedList<>(temphistories);
            }  
        }catch(JsonSyntaxException | JsonIOException | IOException e){
            e.printStackTrace();
        }
        menu.ShowMenu(Combos, history);

    }
}