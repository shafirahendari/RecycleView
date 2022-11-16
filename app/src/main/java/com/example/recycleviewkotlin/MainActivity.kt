package com.example.recycleviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.antman,
                "Ant-Man",
                "AntMan adalah superhero yang memiliki kekuatan untuk membuat tubuhnya mengecil atau membesar. Karakter di balik Ant-Man adalah Scott Lang, seorang mantan napi yang merampok rumah seorang ilmuwan bernama Hank Pym. Awal mula Ant-Man bergabung dengan Avengers adalah ketika Captain America meminta bantuannya ketika dia berselisih paham dengan Tony Stark. Ketika pada akhirnya separuh populasi dunia menghilang karena jentikan jari dari Thanos, Ant-Man adalah seorang superhero yang membantu memberi Avengers lain ide untuk menggunakan Quantum Realm untuk menyelamatkan dunia."
            ),
            Superhero(
                R.drawable.black,
                "Black Window",
                "Sosok Black Widow awalnya dibuat sebagai mata-mata asal Rusia dan anggota KGB (Badan Intelijen Uni Soviet) bernama Natasha Romanoff. Saat bergabung bersama S.H.I.E.L.D., Natasha juga berperan penting dalam menarik superhero lain untuk menjadi anggota tim Avengers.Black Widow memiliki kekuatan bela diri yang luar biasa, ia juga memiliki senjata berbentuk gelang yang mampu memberikan sengatan listrik hingga 30.000 volt. Natasha juga digambarkan sebagai karakter dengan kecerdasan yang mampu melakukan manipulasi psikologis dan bisa menutupi perasaan mereka yang sebenarnya."
            ),
            Superhero(
                R.drawable.captain,
                "Captain America",
                "Captain America adalah superhero tertua di tim Avengers dan sebagai pemimpin tim. Nama asli Captain America adalah Steve Rogers. Dia awalnya adalah orang biasa yang terdaftar di Angkatan Darat Amerika Serikat selama Perang Dunia II. Steve kemudian menjadi seorang prajurit dengan kekuatan yang luar biasa setelah tubuhnya disuntik dengan Serum Super Soldier dan Vita Ray untuk memberinya kekuatan yang besar dibandingkan dengan orang biasa. Dalam cerita MCU, Captain America dikatakan telah membeku di Antartika selama 70 tahun ketika dia mengorbankan dirinya melawan Hydra. Dengan teknologi canggih, Captain America dibangkitkan kembali hingga saat ini dan direkrut oleh S.H.I.E.L.D. untuk menjadi anggota Avengers. Captain America memiliki senjata berupa perisai yang dibuat oleh ayah Tony Stark, yaitu Howard Stark."
            ),
            Superhero(
                R.drawable.hulk,
                "Hulk",
                "Hulk dianggap sebagai superhero dengan kekuatan paling kuat yang dimiliki oleh tim Avengers. Sosok hijau besar ini sebenarnya adalah seorang ilmuwan bernama Bruce Banner, yang terkena bom sinar gamma selama penelitiannya. Bruce Banner bisa berubah menjadi Hulk saat dia marah dan tidak bisa mengontrol emosinya.Sebelum direkrut oleh S.H.I.E.L.D., Dr. Bruce Banner seharusnya mengisolasi dan menenangkan diri untuk menghindari terlibat dalam perkelahian, tetapi ia akhirnya bergabung dengan tim Avengers sekaligus sebagai ilmuwan yang melakukan berbagai penelitian untuk memperkuat tim."
            ),
            Superhero(
                R.drawable.iron,
                "Iron Man",
                "Iron Man sering diidentikkan dengan anggota Avengers yang lebih kaya. Karakter di balik Iron Man adalah Tony Stark, seorang miliarder pemilik Stark Industries. Stark Industries adalah perusahaan kontrak militer yang diwarisi dari ayahnya, Howard Stark. Tony kemudian menciptakan setelan berteknologi tinggi yang disebut Iron Man.Penciptaan Iron Man awalnya terjadi ketika Tony Stark diculik oleh teroris di Afghanistan yang menginginkan misilnya, peristiwa ini juga mengakibatkan dia hampir mati dan pada akhirnya dia harus hidup dengan reaktor di dadanya. Melalui kostum besi ini, Tony telah direkrut sebagai Avengers oleh S.H.I.E.L.D."
            ),
            Superhero(
                R.drawable.spiderman,
                "Spider-Man",
                "Spiderman atau manusia laba-laba adalah seorang superhero yang memiliki kekuatan berupa jaring yang keluar dari tangannya dan memiliki karakter seperti laba-laba. Penampilannya dimulai ketika Peter Parker, seorang siswa sekolah menengah atas, digigit oleh spesies laba-laba langka. Setelah ia mengenali kekuatannya, Peter mendesain kostumnya sendiri. Kemudian, ia menjadi pahlawan penyelamat bernama Spiderman.Dalam cerita MCU, Tony Stark mengunjungi rumah Peter dan Stark mengajaknya bergabung dengan Avengers. Stark bahkan memberi Spiderman beberapa peralatan canggih. Ia juga merupakan anggota Avengers termuda dibandingkan dengan anggota lainnya."
            ),
            Superhero(
                R.drawable.thor,
                "Thor",
                "Berbeda dengan anggota Avengers lainnya yang berasal dari latar belakang manusia yang memiliki kekuatan super, Thor adalah dewa petir dari Asgard. Thor adalah Putra Mahkota Asgard di mana ayahnya adalah Odin, Raja Asgard. Namun, Thor memiliki saudara tiri bernama Loki yang licik dan ingin menguasai Asgard dan dunia.Thor memiliki senjata khasnya yang disebut Mjolnir. Mjolnir adalah palu bertenaga super yang hanya bisa diangkat oleh Thor. Suatu hari, Thor diturunkan ke bumi dan kehilangan kekuatannya sampai dia jatuh cinta dengan seorang gadis bumi. Setelah itu, dia juga kembali ke Bumi ketika Loki membuat kekacauan, yang akhirnya membuat Thor menjadi bagian dari Avengers."
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this,superheroList){
            val intent = Intent(this, DetailSuperHeroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}
