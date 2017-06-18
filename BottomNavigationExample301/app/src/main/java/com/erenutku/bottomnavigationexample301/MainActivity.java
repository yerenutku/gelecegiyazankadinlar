package com.erenutku.bottomnavigationexample301;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.erenutku.bottomnavigationexample301.models.CustomJsonModel;
import com.erenutku.bottomnavigationexample301.models.MyJsonModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    public static final String KEY_CLICK = "tiklanan";
    private BottomNavigationView mBnvMain;
    private FragmentManager mFragmentManager;
    private String myJson = "{\n" +
            "  \"cinsiyet\": true,\n" +
            "  \"yasi\": 24,\n" +
            "  \"ismi\": \"Eren Utku\"\n" +
            "}";
    public static final String URL= "https://raw.githubusercontent.com/yerenutku/cheersgamebackend/gh-pages/backend/games_tr.json?token=AH5kQAkrwQGz58z1WzdQEpHF2gYuiRypks5ZT62twA%3D%3D";
    //region hard coded json string
    private String drinkinggames_json = "{\n" +
            "  \"game_version\": \"1.0.4\",\n" +
            "  \"json_version\": \"1.0.4\",\n" +
            "  \"games\": [\n" +
            "    {\n" +
            "      \"id\": \"0\",\n" +
            "      \"title\": \"Buzz\",\n" +
            "      \"teamsize\": \"Parti\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_8_buzz.png\",\n" +
            "      \"shortexplanation\": \"Ne zaman bir oyuncu yediye bölünebilen bir sayıya gelirse\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Bu oyunda tüm oyuncuların dikkatini oyuna vermesi gerekiyor. Sıranın kaymasına sebep olmak cezaya eşdeğerdir. \",\n" +
            "        \"Her oyuncu sırası geldiğinde saymaya devam eder. İlk başlayan bir, sonraki oyuncu iki diye devam edilir.\",\n" +
            "        \"Ne zaman bir oyuncu yediye bölünebilen bir sayıya gelirse sayısını söylemez, buzz der.Eğer buzz demezse oyuncu içer. Eğer bir oyuncu yanlışlıkla buzz derse o da içer :) \",\n" +
            "        \"Oyunun amacı grubun ne kadar yüksek sayıya ne kadar az buzz ile gelebildiğidir.\",\n" +
            "        \"İki kişilik gruba bölünerek de oynayabilirsiniz. Bunun için iki takım da birer hakem seçer ve hakemlerin sözünün üstüne söz olmaz :)\",\n" +
            "        \"Oyun oldukça acımasız olabilir - dikkatli ol.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"4\",\n" +
            "      \"title\": \"Altı\",\n" +
            "      \"teamsize\": \"2+ kişi\",\n" +
            "      \"type\": \"Shot\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_6_alti.png\",\n" +
            "      \"shortexplanation\": \"Bir zarla saatlerce eğlence!\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"En az üç farklı büyüklükteki(shot bardağı, çay fincanı, büyük bira bardağı gibi) 6 bardağı masaya dizin. Her bardağın 1’den 6’ya kadar bir numarası olsun.\",\n" +
            "        \"Oyun, ilk oyuncunun zarı atmasıyla başlar ve attığı zara denk düşen bardağı ağzına kadar doldurup hızlıca kafaya diker. Artık zar atma sırası bir sonraki oyuncudadır.\",\n" +
            "        \"Birkaç tur sonra oyun ısınacak ve herkes en küçük bardak için dilekler dilemeye totemler yapmaya başlayacak.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"6\",\n" +
            "      \"title\": \"Bardak Çevirmece\",\n" +
            "      \"teamsize\": \"Takımlı\",\n" +
            "      \"type\": \"Bira\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_2_bardak.png\",\n" +
            "      \"shortexplanation\": \"Şişe çevirmece çok mu sıkıcı?\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Oyunculardan iki takım kurun ve her bir oyuncunun önünde yarım dolu bira bardağı olsun.\",\n" +
            "        \"Başla sesiyle birlikte her iki takımın ilk oyuncuları biralarını kafaya dikip bardaklarını ters çevirerek masaya bırakırlar(ağız kısmı masaya gelir)\",\n" +
            "        \"Masaya ters çevrilmiş bardak bırakıldığında sıra bir sonraki takım arkadaşına geçer. Tüm bardaklarını ters çeviren takım kazanır :)\",\n" +
            "        \"Gece sonunda en çok skora sahip takım hesaba dokunmaz! Kaybedenler; kart mı nakit mi?\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"3\",\n" +
            "      \"title\": \"Bira Piştisi\",\n" +
            "      \"teamsize\": \"4+ kişi\",\n" +
            "      \"type\": \"Shot\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_7_bira.png\",\n" +
            "      \"shortexplanation\": \"Kartlar çok mu sıkıcı? Tabularınızı kırın!\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Bir deste kart alın ve oyuncular arasında eşit olarak dağıtırken kartların kapalı olduğuna emin olun.\",\n" +
            "        \"Sırayla her oyuncu bir kartı açarak ortaya koyar, eğer açılan bir sonraki kart öncekiyle aynı değere sahipse(kupa üç ile karo üç veya sinek vale ile maça vale gibi) oyuncular herkesden önce PİŞTİ demeye çalışır.\",\n" +
            "        \"PİŞTİ’yi son söyleyen oyuncu eğer kart 2 ile 6 arasındaysa bir; 7 ile 10arasındaysa iki; vale, kız, papaz veya as ise 3 shot içmelidir. Oyun bütün kartlar açılana kadar devam eder.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"5\",\n" +
            "      \"title\": \"Palyaçoyu Vur\",\n" +
            "      \"teamsize\": \"6+ kişi\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_0_palyaco.png\",\n" +
            "      \"shortexplanation\": \"Kartlar dağıtıldıktan sonra hep beraber 3’e kadar sayılır ve...\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Palyaçoyu vur 52’lik oyun kartlarıyla ve çift sayıda katılımcıyla(6, 8 veya 10 kişi gibi) oynanır. Her oyuncuya kapalı şekilde bir tane kart dağıtılır.\",\n" +
            "        \"Oyuncular kendi kartları da dahil hiçbir kartı göremezler. Kartlar dağıtıldıktan sonra hep beraber 3’e kadar sayılır ve bütün kartlar herkesin görebileceği şekilde açılır !\",\n" +
            "        \"Eğer kartınızın değeri başka bir oyuncunun kartıyla eşleşiyorsa(kupa üç ile karo üç veya sinek vale ile maça vale gibi), o oyuncuyu olabildiğince hızlı bir şekilde elinizle işaret ederek vurun.\",\n" +
            "        \"Katılımcılar birbirine vuracak kadar yakın değilse işaret ettikten sonra seçtiğiniz bir kelime ile bağırılır(örneğin pişti diye bağırabilirsiniz)\",\n" +
            "        \"Henüz vuramamış oyuncu sona kalan oyuncudur ve kartının değeri kadar içkisinden yudum alır\",\n" +
            "        \"Eğer bir oyuncu kartının değeri eş olmadığı halde başka bir oyuncuyu vurduysa(işaret ettiyse) iki kez içmelidir.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"8\",\n" +
            "      \"title\": \"Yasak Kelime\",\n" +
            "      \"teamsize\": \"2+ kişi\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_5_yasak.png\",\n" +
            "      \"shortexplanation\": \"Yasak kelimeyi söyleyen kişi tabii ki içmeli\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Yasak bir kelime seçin ve yasak kelimeyi söyleyen kişi tabii ki içmeli. Zor bir kelime seçmek zorunda değilsiniz. “bu”, “ben”, “ya” gibi kelimeler iyi birer seçim olabilir.\",\n" +
            "        \"Alternatif olarak “evet” ve “hayır” kelimelerini de yasaklayabilirsiniz. Bu şekilde birbirinize evet hayır şeklinde cevaplanacak sorular sorarak tuzak kurmanız da mümkün olacaktır :)\",\n" +
            "        \"Örneğin evet kelimesini yasakladıktan sonra hiç ata bindin mi sorusu ile karşınızdakine içirebilirsiniz. Sonra ondan tekrar binmesini isteyin(anlamayanlara altyazı: organize işler)\",\n" +
            "        \"Ya kelimesini yasaklarsanız ortamdaki tikilerin zil zurna sarhoş olacağını unutmayın.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"2\",\n" +
            "      \"title\": \"Don ya da İç\",\n" +
            "      \"teamsize\": \"Parti\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_3_don.png\",\n" +
            "      \"shortexplanation\": \"Parti boyunca devam ederek geceyi canlı tutar\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Diğer oyunlardan farklı olarak “Don ya da İç” parti boyunca sürekli devam eden bir oyundur. Bir Bay veya Bayan dondurucu seçin.\",\n" +
            "        \"Parti süresince herhangi bir an Bay veya Bayan dondurucu bir heykel gibi donup kalacaktır. Onun donduğunu fark eden herkes de fark ettiği anda donmalıdır.\",\n" +
            "        \"Son fark eden için içme vaktidir. Dondurucu yeni bir dondurucu seçene kadar dondurucu olmaya devam eder.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"title\": \"Köprüyü Geç\",\n" +
            "      \"teamsize\": \"4+ kişi\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_9_kopru.png\",\n" +
            "      \"shortexplanation\": \"Kız için iki yudum, Papaz için üç yudum\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"İskambil destesini iyice karıştır ve içerisinden 10 tanesini kapalı ve düz bir şekilde masaya diz. Bu desteye Köprü denir!\",\n" +
            "        \"İlk oyuncu, ilk kartı açar. 2 ve 10 arasında bir değerse, korkmana gerek yok, güvendesin.\",\n" +
            "        \"Eğer kart bacak, kız, papaz ya da as ise onun değeri kadar bir içki içer. (Bacak için bir yudum, Kız için iki yudum, Papaz için üç yudum ve As için dört yudum)\",\n" +
            "        \"Sıra, sıradaki diğer oyuncuya geçer. Köprünün sonuna yaklaşırken, iskambil destenden 10 yeni kart eklemeyi unutma.\",\n" +
            "        \"Oyun, bütün kartlar bittiğinde biter!\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"7\",\n" +
            "      \"title\": \"Hızlı Sorular\",\n" +
            "      \"teamsize\": \"Parti\",\n" +
            "      \"type\": \"Bira\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_1_hizli.png\",\n" +
            "      \"shortexplanation\": \"Birbirinizi sorgulamak hiç bu kadar eğlenceli olmamıştı\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Bu oyunda her oyuncu sırası geldiğinde diğer bir oyuncuyu sorgular ve katılımcılar arasında eğlenceli muhabbetlerin dönmesini sağlar.\",\n" +
            "        \"İlk soruyu soran oyuncu başka bir oyuncunun adını söyleyerek ona evet ya da hayır şeklinde cevaplandırılması gereken bir soru sorar. Bu soru sorulduğu anda cevaplandırılmalıdır.\",\n" +
            "        \"Kendisine soru sorulan kişi ise duraklamadan farklı bir soruyu başka bir oyuncuya sormalı ancak tahmin edeceğiniz üzere bu oyun kıpır kıpır ve hızlı.\",\n" +
            "        \"Herhangi bir duraksama, tereddüt, uzun düşünme ve yanıtlandırmadan önce gülme bir yüksek alkollü shot bira ile cezalandıracaktır.\",\n" +
            "        \"Oyuncuları en çok düşündüren sorular tabii ki özel hayatlarını sorgulayan sorulardır. Bu soruların oyunun ortalarına doğru sorulması cevaplanma oranını ve doğruluğunu artırır.\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"9\",\n" +
            "      \"title\": \"Ben Hiç ...\",\n" +
            "      \"teamsize\": \"2+ kişi\",\n" +
            "      \"type\": \"Tüm içkiler\",\n" +
            "      \"typeicon\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/bira.png\",\n" +
            "      \"cardimage\": \"http://yerenutku.github.io/cheersgamebackend/backend/games_images/icon_4_ben.png\",\n" +
            "      \"shortexplanation\": \"Birbirinizi tanımanın eğlenceli yolu\",\n" +
            "      \"fragmentdetail\": [\n" +
            "        \"Birbirinizi tanımanın eğlenceli bir yolu, her oyuncu sırayla hayatına dair bir “Ben hiç…” cümlesi kurmalı.\",\n" +
            "        \"Örneğin “Ben hiç çıplak yüzmedim” bu durumda masa etrafındaki daha önce çıplak yüzen herkes içki içmeli :)\",\n" +
            "        \"Oyunun amacı ise hayatınıza dair hiç deneyimlemediğiniz ama herkesin içmesini sağlayacak bir cümle ile çıkagelmek.\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences("sharedpreferences_bottom", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        final Gson gson = new GsonBuilder().create();
        //region json ornegi, onemsiz
        Log.d("JSON", myJson);
        MyJsonModel myJsonModel = gson.fromJson(myJson, MyJsonModel.class);
        Log.d("GSON", myJsonModel.getIsmi());
        Log.d("GSON", String.valueOf(myJsonModel.getAge()));
        Log.d("GSON", myJsonModel.isCinsiyet() + "");
        //endregion

        CustomJsonModel benimmodelim = gson.fromJson(drinkinggames_json, CustomJsonModel.class);

        Log.d("DRINKING", benimmodelim.getGameVersion());
        for (int i = 0; i < 10; i++) {
            Log.d("DRINKING", benimmodelim.getGames().get(i).getShortexplanation());
        }

        final FirstFragment fragment1 = FirstFragment.newInstance("Hoşgeldiniz");
        final SecondFragment secondFragment = new SecondFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();

        mBnvMain = (BottomNavigationView) findViewById(R.id.bnvMain);
        mBnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_face:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();
                        break;
                    case R.id.action_likes:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, secondFragment).commit();
                        break;
                    case R.id.action_credit:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miFace:
                Toast.makeText(this, "surat", Toast.LENGTH_LONG).show();
                mEditor.putString(KEY_CLICK, "surat");
                break;
            case R.id.miLike:
                Toast.makeText(this, "kalp", Toast.LENGTH_SHORT).show();
                mEditor.putString(KEY_CLICK, "kalp");
                break;
            case R.id.miInfo:
                Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();
                mEditor.putString(KEY_CLICK, "info");
                break;
        }
        mEditor.commit();
        return super.onOptionsItemSelected(item);
    }
}
