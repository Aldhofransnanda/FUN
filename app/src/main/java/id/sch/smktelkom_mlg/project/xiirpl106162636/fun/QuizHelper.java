package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

/**
 * Created by Fadwa on 10/18/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    private static final String TABLE_USER = "user";
    private static final String TABLE_SCORE = "score";
    private static final String TABLE_CHAPTER = "chapter";
    private static final String TABLE_LESSON = "lesson";

    // tasks Question Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_OPTD = "optd"; // option d
    private static final String KEY_OPTE = "opte"; // option e

    // tasks Question Chapter Columns names
    private static final String CHAP_ID = "cid";
    private static final String CHAP_NUMBER = "chapter_number";

    // tasks Question Lesson Columns names
    private static final String LESSON_ID = "lid";
    private static final String LESSON_NAME = "lesson_name";

    // tasks Question Score Columns names
    private static final String SCORE_ID = "sid";
    private static final String SCORE_VALUE = "score_value";

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LESSON_ID + " INTEGER, " + CHAP_ID + " INTEGER, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD
                + " TEXT, " + KEY_OPTE + " TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS " + TABLE_CHAPTER + " ( "
                + CHAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LESSON_ID + " INTEGER, " + CHAP_NUMBER + " TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS " + TABLE_LESSON + " ( "
                + LESSON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LESSON_NAME + " TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE + " ( "
                + SCORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LESSON_ID + "INTEGER, " + LESSON_NAME + " TEXT, " + CHAP_ID + "INTEGER, " + SCORE_VALUE + " INTEGER)";
        db.execSQL(sql);
        addQuestion();
        addChapter();
        addLesson();
        // db.close();
    }


    private void addLesson() {
        Lesson l1 = new Lesson("Bahasa Indonesia");
        this.addLesson(l1);
        Lesson l2 = new Lesson("Matematika");
        this.addLesson(l2);
        Lesson l3 = new Lesson("Bahasa Inggris");
        this.addLesson(l3);
    }

    private void addChapter() {
        Chapter c1 = new Chapter(1, 1);
        this.addChapter(c1);
        Chapter c2 = new Chapter(1, 2);
        this.addChapter(c2);
        Chapter c3 = new Chapter(1, 3);
        this.addChapter(c3);
        Chapter c4 = new Chapter(1, 4);
        this.addChapter(c4);
        Chapter c5 = new Chapter(1, 5);
        this.addChapter(c5);
    }

    private void addQuestion() {
        Question q1 = new Question(1, 1, "Menteri Keuangan RI, Bambang Brodjonegoro yang hadir sebagai narasumber dalam seminar itu mengatakan, indikator keberhasilan pemerintahan di negara maju adalah realisasi target pemenuhan lapangan kerja. Menurut Bambang, dengan pemenuhan lapangan kerja maka secara otomatis tingkat kemiskinan menurun. Hal ini menjadi salah satu perhatian pemerintah saat itu. \n Makna istilah kata indikator pada bacaan tersebut adalah … \nA. Sesuatu yang dapat menjadi motivasi \nB. Sesuatu yang dapat memberi penjelasan \nC. Sesuatu yang dapat memberi petunjuk \nD. Sesuatu yang dapat menjadi dukungan \nE. Sesuatu yang dapat memberi manfaat",
                "Sesuatu yang dapat menjadi motivasi",
                "Sesuatu yang dapat memberi penjelasan",
                "Sesuatu yang dapat memberi petunjuk",
                "Sesuatu yang dapat menjadi dukungan",
                "Sesuatu yang dapat memberi manfaat",
                "Sesuatu yang dapat memberi petunjuk");
        this.addQuestion(q1);
        Question q2 = new Question(1, 1, "Bila Anda gemar melakukan perjalanan jauh dengan menggunakan pesawat, berikut ini merupakan cara untuk mendapatkan kenyamanan. Untuk dapat lebih memperoleh kenyamanan, biasakan datang lebih awal, saat memilih tiket pilihan tempat duduk di belakang atau tengah. Hal lain, pilah barang bawaan menjadi dua bagian untuk di kabin dan untuk masuk bagasi. Dalam penerbangan, pakailah sepatu yang mudah dilepas dan siapkan bacaan. \nGagasan pokok paragraf tersebut adalah … \nA. Cara melakukan penerbangan yang praktis dan nyaman \nB. Strategi dalam melakukan penerbangan \nC.Hal-hal yang perlu dilakukan dalam penerbangan \nD. Cara memperoleh kenyamanan dalam penerbangan \nE. Kiat-kiat melakukan penerbangan jauh",
                "Cara melakukan penerbangan yang praktis dan nyaman",
                "Strategi dalam melakukan penerbangan",
                "Hal-hal yang perlu dilakukan dalam penerbangan",
                "Cara memperoleh kenyamanan dalam penerbangan",
                "Kiat-kiat melakukan penerbangan jauh",
                "Cara memperoleh kenyamanan dalam penerbangan");
        this.addQuestion(q2);
        Question q3 = new Question(1, 1, "Keadaan pekerjaan anak-anak memang dilematis. Disetujui, anak-anak bekerja untuk menambah pendapatan keluarga, tetapi di sisi lain tereksplotasi. Ironisnya, kadang-kadang anak-anak tidak menyadari hal itu. Mereka tidak sadar bahwa jam kerja yang diperolehnya adalah 20 jam per minggu. Realitasnya, anak-anak harus bekerja lebih dari 35 jam dalam perminggu. Ini sudah melanggar konvensi ILO No. 138/197. \nSimpulan paragraf tersebut adalah … \nA. Pekerja anak-anak menambah pendapatan keluarga \nB. Pekerja anak-anak seharusnya bekerja sesuai dengan konvensi ILO \nC. Eksploitasi terhadap anak-anak sering dilakukan orangtuanya \nD. Pekerja anak-anak bekerja melebihi batas maksimal \nE. Orang tua mengeksploitasi pekerja anak-anak",
                "Pekerja anak-anak menambah pendapatan keluarga",
                "Pekerja anak-anak seharusnya bekerja sesuai dengan konvensi ILO",
                "Eksploitasi terhadap anak-anak sering dilakukan orangtuanya",
                "Pekerja anak-anak bekerja melebihi batas maksimal",
                "Orang tua mengeksploitasi pekerja anak-anak",
                "Orang tua mengeksploitasi pekerja anak-anak");
        this.addQuestion(q3);
        Question q4 = new Question(1, 1, "Situs purbakala di kawasan Kota Banda Aceh kuno saat ini dalam kondisi terbengkalai. Rumput ilalang tumbuh subur di kawasan itu. Makam-makam kuno peninggalan masa kerajaan Aceh yang dibuat sekitar abad ke-17 dan ke-18 berserak tak terurus. Banyak yang tidak utuh dan terbelah. Sebagian batu nisan berkaligrafi musnah terbawa tsunami atau diambil orang. Manuskrip batu nisan berserakan dan tak diketahui lagi posisi awalnya. Padahal, tulisan kaligrafi pada nisan itu mempunyai pesan dan/atau teks sejarah yang berguna. \nPernyataan yang sesuai dengan isi paragraf tersebut adalah … \nA. Semua makam kuno di Banda Aceh musnah karena terbawa tsunami \nB. Pemerintah diharapkan segera mengumpulkan lagi peninggalan yang ada \nC.Kompleks makam yang hilang direnovasi kembali oleh pemerintah \nD. Situs purbakala Banda Aceh telah ditata kembali oleh pemerintah daerah \nE. Tulisan kaligrafi pada nisan berisi data diri yang meninggal",
                "Semua makam kuno di Banda Aceh musnah karena terbawa tsunami",
                "Pemerintah diharapkan segera mengumpulkan lagi peninggalan yang ada",
                "Kompleks makam yang hilang direnovasi kembali oleh pemerintah",
                "Situs purbakala Banda Aceh telah ditata kembali oleh pemerintah daerah",
                "Tulisan kaligrafi pada nisan berisi data diri yang meninggal",
                "Tulisan kaligrafi pada nisan berisi data diri yang meninggal");
        this.addQuestion(q4);
        Question q5 = new Question(1, 1, "(1) Tenaga yang besar dalam gelombang tsunami mampu menyapu bangunan di daratan dengan mudah. (2) Gelombang tsunami mampu merambat dengan kecepatan yang tak terbayangkan. (3) kecepatannya bisa mencapai 500 sampai 1000 kilometer per jam di lautan. (4) pada saat mencapai bibir pantai, kecepatannya berkurang menjadi 50 sampai 30 kilometer per jam. (5) meskipun berkurang pesat, kecepatan tersebut sudah mampu menyebabkan kerusakan yang parah di daratan sehingga menyusahkan semua orang. \nKalimat yang didalamnya terkandung hubungan sebab akibat dalam paragraf tersebut adalah nomor … \nA. (1) dan (2) \nB. (2) dan (3) \nC. (3) dan (4) \nD. (2) dan (4) \nE. (1) dan (5)",
                "(1) dan (2)",
                "(2) dan (3)",
                "(3) dan (4)",
                "(2) dan (4)",
                "(1) dan (5)",
                "(1) dan (5)");
        this.addQuestion(q5);
        Question q6 = new Question(1, 1, "Katakan tidak untuk narkoba! \nIsi teks iklan tersebut adalah … \n A. Hati-hati jika ada orang yang menawari narkoba \nB. Sekali Anda mencoba narkoba, pasti anda ketagihan \nC. Jangan sekali-sekali menggunakan narkoba \nD. Hati-hati terhadap orang yang membawa narkoba \nE. Jangan mendekati korban narkoba",
                "Hati-hati jika ada orang yang menawari narkoba",
                "Sekali Anda mencoba narkoba, pasti anda ketagihan",
                "Jangan sekali-sekali menggunakan narkoba",
                "Hati-hati terhadap orang yang membawa narkoba",
                "Jangan mendekati korban narkoba",
                "Jangan sekali-sekali menggunakan narkoba");
        this.addQuestion(q6);
        Question q7 = new Question(1, 1, "Sejak wacana pengembangan Kurikulum 2013 dilaksanakan, muncul tanggapan pro dan kontra dari berbagai kalangan pakar dan praktisi pendidikan, serta banyak kritik dan saran terhadap Kurikulum 2013 ini. Mereka mengharapkan agar kurikulum ini lebih dimatangkan. \nTanggapan logis terhadap paragraf tersebut adalah … \n A. Wacana pro dan kontra menunjukkan bahwa para pemangku kepentingan memiliki kepedulian akan pentingnya pembangunan sistem pendidikan di negeri ini  \nB. Wacana pro dan kontra menunjukkan bahwa tidak semua pemangku kepentingan dilibatkan dalam penyusunan Kurikulum 2013 \nC. Kurikulum 2013 sebenarnnya hanyalah perubahan dari kurikulum sebelumnya, yakni kurikulum tingkat satuan pendidikan \nD. Perubahan mendasar Kurikulum 2013 dari kurikulum sebelumnya adalah tentang standar isi, standar proses, standar penilaian, dan standar kompetensi kelulusan \nE. Kurikulum 2014 secara komprehensif mengajarkan tentang sikap, pengetahuan dan keterampilan dibandingkan kurikulum sebelumnya yang hanya mengajarkan pengetahuan",
                "Wacana pro dan kontra menunjukkan bahwa para pemangku kepentingan memiliki kepedulian akan pentingnya pembangunan sistem pendidikan di negeri ini",
                "Wacana pro dan kontra menunjukkan bahwa tidak semua pemangku kepentingan dilibatkan dalam penyusunan Kurikulum 2013",
                "Kurikulum 2013 sebenarnnya hanyalah perubahan dari kurikulum sebelumnya, yakni kurikulum tingkat satuan pendidikan",
                "Perubahan mendasar Kurikulum 2013 dari kurikulum sebelumnya adalah tentang standar isi, standar proses, standar penilaian, dan standar kompetensi kelulusan",
                "Kurikulum 2014 secara komprehensif mengajarkan tentang sikap, pengetahuan dan keterampilan dibandingkan kurikulum sebelumnya yang hanya mengajarkan pengetahuan",
                "Wacana pro dan kontra menunjukkan bahwa para pemangku kepentingan memiliki kepedulian akan pentingnya pembangunan sistem pendidikan di negeri ini");
        this.addQuestion(q7);
        Question q8 = new Question(1, 1, "(1) Sedikitnya 7,5 ton pempek dikirim ke luar Palembang sebagai oleh-oleh. (2) Selain itu, pempek juga berfungsi sebagai pengikat tali silaturahim. (3) Berarti saat ini penggemar pempek lebih banyak daripada tahun-tahun sebelumnya. (4) Kondisi ini dapat meningkatkan omzet rumahan di sana. (5) Makanan khas Palembang ini mampu menggerakkan ekonomi daerah. \nKalimat yang didalamnya terkandung hubungan perbandingan adalah nomor … \nA. (1) \nB. (2) \nC. (3) \nD. (4) \nE. (5)",
                "(1)",
                "(2)",
                "(3)",
                "(4)",
                "(5)",
                "(2)");
        this.addQuestion(q8);
        Question q9 = new Question(1, 1, "Kamu tentu tahu siapa Pak Pos. Dialah yang mengantarkan surat-suratmu, baik surat yang kau kirim maupun yang kau terima. Melalui surat, kamu dapat berhubungan dengan saudara-saudaramu atau sahabat di tempat jauh. \nRingkasan paragraf tersebut adalah … \nA. Surat adalah alat komunikasi yang sangat bermanfaat \nB. Pak pos adalah orang yang bertugas mengantar surat kepada siapa saja \nC. Melalui surat, kita dapat berhubungan dengan orang lain \nD. Surat merupakan benda pos yang sangat diperlukan oleh masyarakat \nE. Pak Pos adalah yang mengantarkan surat-suratmu, sehingga kamu dapat berhubungan dengan orang lain di tempat jauh",
                "Surat adalah alat komunikasi yang sangat bermanfaat",
                "Pak pos adalah orang yang bertugas mengantar surat kepada siapa saja",
                "Melalui surat, kita dapat berhubungan dengan orang lain",
                "Surat merupakan benda pos yang sangat diperlukan oleh masyarakat",
                "Pak Pos adalah yang mengantarkan surat-suratmu, sehingga kamu dapat berhubungan dengan orang lain di tempat jauh",
                "Melalui surat, kita dapat berhubungan dengan orang lain");
        this.addQuestion(q9);
        Question q10 = new Question(1, 1, "Segala kupinta tiada ku beri \nSegala kutanya tiada kau sakiti \nButalah aku berdiri sendiri \nPenuntun tiada memimpin jari\nMajas yang terdapat dalam kutipan puisi tersebut adalah … \nA. Anafora \nB. Epifora \nC. Anafora \nD. Personifikasi \nE. Anafora",
                "Epifora",
                "Metafora",
                "Anafora",
                "Personifikasi",
                "Litotes",
                "Anafora");
        this.addQuestion(q10);

        Question q11 = new Question(1, 2, "Kalau tidak aku karyakan, tentu telah berkurang satu pekerja keliling seperti dia. Dua hari yang lalu kukemas pakaian-pakaian bekas anakku yang tidak muat lagi dikenakan. Aku sisihkan juga baju tua milikku sekalian baju tua istriku. Pakaian-pakaian itu kuberikan kepadanya di samping upah yang dia terima. Kami sebenarnya bukan orang yang mapan, tapi kebiasaan itu telah ditanamkan orang tua sejak kecil. \nAmanat yang terkandung dalam penggalan cerpen tersebut adalah … \nA. Tanamkan kebiasaan bersedekah sejak kecil. \nB. Barang-barang bekas bisa bermanfaat jika dijual. \nC. Bersedekahlah jika sudah jadi orang mapan. \nD. Pakaian bekas bisa dijadikan pengganti upah. \nE. Tolong-menolonglah dalam kehidupan keluarga.",
                "Tanamkan kebiasaan bersedekah sejak kecil",
                "Barang-barang bekas bisa bermanfaat jika dijual",
                "Bersedekahlah jika sudah jadi orang mapan",
                "Pakaian bekas bisa dijadikan pengganti upah",
                "Tolong-menolonglah dalam kehidupan keluarga",
                "Tanamkan kebiasaan bersedekah sejak kecil");
        this.addQuestion(q11);
        Question q12 = new Question(1, 2, "Andi mengangkat telepon dan mulai berbicara dengan relasinya, setelah ada dua menit berbicara, tangan kanannya yang mengangkat gagang telepon tiba-tiba gemetar. Dan dalam hitungan detik, gemetar itu berubah menjadi bergetar. Dalam kegemetarannya Andi segera memencet tombol speaker karena tangannya tak bisa lagi megang telepon. Dalam sekejap Andi melorot jatuh ke lantai. Tubuhnya terbujur kaku. Tak bergerak lagi \nTahap alur yang digunakan dalam penggalan novel tersebut adalah … \nA. Pengenalan situasi cerita \nB. Pengungkapan peristiwa \nC.Menuju terjadinya konflik \nD. Puncak konflik (klimaks) \nE. Penyelesaian cerita (ending)",
                "Pengenalan situasi cerita",
                "Pengungkapan peristiwa",
                "Menuju terjadinya konflik",
                "Puncak konflik (klimaks)",
                "Penyelesaian cerita (ending)",
                "Puncak konflik (klimaks)");
        this.addQuestion(q12);
        Question q13 = new Question(1, 2, "“Hey ayo cepat!” Begitulah Rumirah mengajak teman-temannya bergegas berdiri. Suaminya langsung menyibak kain terpal menutup bak truk. Dengan sigap ia menurunkan barang dengan melemparkan ke teman-teman istrinya. Mereka dengan sigap mengaitkan selendang dan keranjang di punggung. Sesekali mereka menyeka leher dan pipi dengan selendang sambil berjalan terbungkuk-bungkuk menuju lorong-lorong.\nLatar dalam penggalan novel tersebut adalah … \nA. Di tepi jalan \nB. Terminal bus \nC. Stasiun kereta api \nD. Stasiun kereta api \nE. Di dalam truk",
                "Di tepi jalan",
                "Terminal bus",
                "Stasiun kereta api",
                "Tempat perhentian bus",
                "Di dalam truk",
                "Di dalam truk");
        this.addQuestion(q13);
        Question q14 = new Question(1, 2, "Cucu-cucuku\nNegara terlanda gelombang zaman edan\nCita-cita kebajikan terhempas waktu\nLesu dipangku batu\nTetapi aku keras bertahan\nMenghadapi akal sehat dan suara jiwa\nBiarpun tercampak di selokan zaman\nTema penggalan puisi tersebut adalah …\nA. Keprihatinan akan negara yang dilanda zaman edan. \nB. Negara yang dilanda bencana gelmbang tsunami. \nC.Negara ini banyak orang hilang akal. \nD. Kebajikan mengalahkan kelaliman. \nE. Negara yang banyak dilanda bencana.",
                "Keprihatinan akan negara yang dilanda zaman edan.",
                "Negara yang dilanda bencana gelmbang tsunami.",
                "Negara ini banyak orang hilang akal.",
                "Kebajikan mengalahkan kelaliman.",
                "Negara yang banyak dilanda bencana.",
                "Keprihatinan akan negara yang dilanda zaman edan.");
        this.addQuestion(q14);
        Question q15 = new Question(1, 2, "Karim\t: Sudah sepuluh purnama ayah tidak pulang ya, Bu? Aku merindukan candanya yang ceria, sorot matanya yang jenaka, dan nasihatnya yang menyejukkan.\nIbu\t: Sabar, Nak. Jangan kita putus-putus berdoa, semoga ayahmu dalam lindungan Tuhan.\nKarim\t: Ibu dengan Ayah tidak ada masalah kan?\nIbu\t: (sambil memeluk Karim) Maafkan Ibu, Nak. Ibu tidak dapat menerima Ayah lagi, sejak dia menikahi perempuan desa seberang. \nKarim\t: (Memandang wajah ibunya sambil menahan dadanya yang sakit akibat sakit paru-paru yang dideritanya) Mengapa selama ini tidak menceritakan pada Karim, Bu?\nInti penggalan naskah drama di atas adalah …\nA. Karim menderita sakit paru-paru \nB. Ayah dan Ibu sudah bercerai \nC. Nasihat Ayah Karim sangat menyejukkan \nD. Ibu Karim sangat sabar dan baik hati \nE. Karim sangat merindukan Ayahnya yang berada di seberang",
                "Karim menderita sakit paru-paru",
                "Ayah dan Ibu Karim sudah bercerai",
                "Nasihat Ayah Karim sangat menyejukkan",
                "Ibu Karim sangat sabar dan baik hati",
                "Karim sangat merindukan Ayahnya yang berada di seberang",
                "Karim sangat merindukan Ayahnya yang berada di seberang");
        this.addQuestion(q15);
        Question q16 = new Question(1, 2, "Waktu Holil anak Haji Zainuri sunat, aku masih amat kecil. Di kotaku belum ada listrik. Apalagi radio dan bioskop. Hiburan satu-satunya bagi anak-anak kecil di waktu sore hari ialah menonton orang memasang lampu petromaks yang dikerek di setiap perempatan jalan dan memburu-buru gangsir atau laron bilamana musimnya tiba. \nUnsur ekstrinsik yang ingin ditonjolkan dari cerita tersebut adalah latar belakang … \n A. Sosial masyarakat \nB. Budaya masyarakat \nC. Sosial pengarang \nD. Sejarah penciptaan \nE. Agama pengarang",
                "Sosial masyarakat",
                "Budaya masyarakat",
                "Sosial pengarang",
                "Sejarah penciptaan",
                "Agama pengarang",
                "Sosial masyarakat");
        this.addQuestion(q16);
        Question q17 = new Question(1, 2, "Awalnya ia hanya tukang cuci piring di rumah makan milik seorang perantau dari Lareh Pajang yang lebih dahulu mengadu untung di Jakarta. Sedikit demi sedikit dikumpulkannya modal agar tidak selalu bergantung pada induk semang. Berkat kegigihan dan kerja keras selama bertahun-tahun, Azrial kini sudah jadi juragan, punya enam rumah makan dan dua puluh empat anak buah yang tiap hari sibuka dengan melayani pelanggan.\nDilihat dari sudut pandang penceritaan kutipan cerpen tersebut menggunakan sudut pandang … \n A. Orang pertama sebagai pelaku utama\nB. Orang pertama sebagai pelaku pendamping \nC. Orang kedua sebagai pelaku pendamping \nD. Orang ketiga sebagai pelaku pendamping \nE. Orang ketiga sebagai pelaku utama",
                "Orang pertama sebagai pelaku utama",
                "Orang pertama sebagai pelaku pendamping",
                "Orang kedua sebagai pelaku pendamping",
                "Orang ketiga sebagai pelaku pendamping",
                "Orang ketiga sebagai pelaku utama",
                "Orang ketiga sebagai pelaku utama");
        this.addQuestion(q17);
        Question q18 = new Question(1, 2, "Gua tempat Naga itu terletak di sebuah puncak gunung yang disebut gunung Naga Berlian. Banyak orang yang tertarik pergi ke gua itu karena ingin memiliki permata berlian yang indah itu. Tapi, tidak ada yang berhasil memperolehnya. Semua menemui ajalnya, menjadi santapan Sang Naga. Ia selalu menghadapi siapa saja yan mencoba mengambil permata itu. \nWatak Sang Naga pada kutipan teks tersebut adalah … \nA. Kejam \nB. Penyayang \nC. Setia \nD. Gigih \nE. Pemarah",
                "Kejam",
                "Penyayang",
                "Setia",
                "Gigih",
                "Pemarah",
                "Kejam");
        this.addQuestion(q18);
        Question q19 = new Question(1, 2, "Semua bersedih. Langit pun tampak mendung, seakan ikut bersedih. Jenazah Yuda terbaring kaku di ruangan depan. Masyarakat datang berbondong-bondong memenuhi rumah duka. Mereka ikut kehilangan seseorang yang selama ini dikenal sangat rajin mengurus masjid, ramah, dan ringan tangan dalam memberi bantuan. Sebagian masyarakat sudah berangkat ke pemakaman untuk menggali kuburan dan mempersiapkan pemakaman. \nNilai sosial yang terdapat dalam penggalan cerita tersebut adalah … \nA. Masyakarat yang dengan suka rela menjenguk orang yang kemalangan dan bergotong-royong mempersiapkan pemakaman. \nB. Manusia yang saling memaafkan jika berbuat kesalahan. \nC. Mengikhlaskan manusia jika telah meninggal dunia. \nD. Segala sesuatu yang diciptakan Tuhan akan kembali lagi kepada Tuhan. \nE. Bersedih ketika melihat ada teman yang meninggal.",
                "Masyakarat yang dengan suka rela menjenguk orang yang kemalangan dan bergotong-royong mempersiapkan pemakaman.",
                "Manusia yang saling memaafkan jika berbuat kesalahan.",
                "Mengikhlaskan manusia jika telah meninggal dunia.",
                "Segala sesuatu yang diciptakan Tuhan akan kembali lagi kepada Tuhan.",
                "Bersedih ketika melihat ada teman yang meninggal.",
                "Masyakarat yang dengan suka rela menjenguk orang yang kemalangan dan bergotong-royong mempersiapkan pemakaman.");
        this.addQuestion(q19);
        Question q20 = new Question(1, 2, "Novel Salah Asuhan dikarang oleh Abdul Muis, seorang putra Minangkabau yang berkecimpung dalam dunia politik dan juga seorang wartawan. Banyak karya sastra yang ditulisnya, antara lain Pertemuan Jodoh (1993), Surapati (1950), Robert Anak Surapati (1953), dan cerita terjemahan Tom Sawyer Anak Amerika dan Don Kisot. \n\nA. Anafora \nB. Epifora \nC. Anafora \nD. Personifikasi \nE. Anafora",
                "Identitas buku",
                "Keunggulan dan kelemahan",
                "Sinopsis cerita",
                "Kepengarangan",
                "Kebahasaan pengarang",
                "Kebahasaan pengarang");
        this.addQuestion(q20);
        Question q21 = new Question(3, 1, "PT Natari Corporation is an Indonesia-based company which engaged in infrastructure, telecommunication and plantations. The company’s activities comprises general trading, construction, agriculture, mining, industry – especially steel pipe manufacturing, building materials and construction products – telecommunication systems, electronic and electrical goods, and investment including equity investment in other companies.\nThe three core business areas of the company manage : infrastructure support sector, which participates in accelerating infrastructure programs set by government; telecommunication sector, which further improves the marketing of its products and services in order to maximize profit; and plantation sector, which prominently produces palm oil, latex and natural rubber. As of December 31, 2011, the company owned 22 direct subsidiaries.\nThe Natari Corporation increases the company’s market … \nA. Through the plantation sector \nB. By selling its products cheaply \nC. By accelerating infrastructure programs \nD. Through its telecommunication sector businesses \nE. Through agriculture and mining activities",
                "Through the plantation sector",
                "By selling its products cheaply",
                "By accelerating infrastructure programs",
                "Through its telecommunication sector businesses",
                "Through agriculture and mining activities",
                "Through its telecommunication sector businesses");
        this.addQuestion(q21);
        Question q22 = new Question(3, 1, "PT Natari Corporation is an Indonesia-based company which engaged in infrastructure, telecommunication and plantations. The company’s activities comprises general trading, construction, agriculture, mining, industry – especially steel pipe manufacturing, building materials and construction products – telecommunication systems, electronic and electrical goods, and investment including equity investment in other companies.\nThe three core business areas of the company manage : infrastructure support sector, which participates in accelerating infrastructure programs set by government; telecommunication sector, which further improves the marketing of its products and services in order to maximize profit; and plantation sector, which prominently produces palm oil, latex and natural rubber. As of December 31, 2011, the company owned 22 direct subsidiaries.\nA. The plantation sector \nB. The investment sector \nC. The infrastructure sector \nD. The telecommunication sector \nE. The manufacture sector",
                "The plantation sector",
                "The investment sector",
                "The infrastructure sector",
                "The telecommunication sector",
                "The manufacture sector",
                "The infrastructure sector");
        this.addQuestion(q22);
        Question q23 = new Question(3, 1, "PT Natari Corporation is an Indonesia-based company which engaged in infrastructure, telecommunication and plantations. The company’s activities comprises general trading, construction, agriculture, mining, industry – especially steel pipe manufacturing, building materials and construction products – telecommunication systems, electronic and electrical goods, and investment including equity investment in other companies.\nThe three core business areas of the company manage : infrastructure support sector, which participates in accelerating infrastructure programs set by government; telecommunication sector, which further improves the marketing of its products and services in order to maximize profit; and plantation sector, which prominently produces palm oil, latex and natural rubber. As of December 31, 2011, the company owned 22 direct subsidiaries.\nHow does the Writer describe PT. Natari? \nA. a foreign firm \nB. a franchise business \nC. a multi-sector company \nD. a new developing branch \nE. a telecommunication business",
                "a foreign firm",
                "a franchise business",
                "a multi-sector company",
                "a new developing branch",
                "a telecommunication business",
                "a multi-sector company");
        this.addQuestion(q23);
        Question q24 = new Question(3, 1, "Matraman Raya 33\nJakarta\n12 July 2016\nDear Febriana,\nIt has been a long time since I saw you. I am just waiting for my holidays to get over and meet you soon. I hope the work has been going well for you at office. There is only few days left in my holidays and after that it’s back to work. I’ve bought lots of stuff for you.\nYour sincerely,\nAmanda \nFrom the text above we know that Amanda is … \nA. Febriana’s mom \nB. Febriana’s niece \nC.  Febriana’s cousin \nD. Febriana’s sister \nE. Febriana’s colleague",
                "Febriana’s mom",
                "Febriana’s niece",
                "Febriana’s cousin",
                "Febriana’s sister",
                "Febriana’s colleague",
                "Febriana’s colleague");
        this.addQuestion(q24);
        Question q25 = new Question(3, 1, "Matraman Raya 33\nJakarta\n12 July 2016\nDear Febriana,\nIt has been a long time since I saw you. I am just waiting for my holidays to get over and meet you soon. I hope the work has been going well for you at office. There is only few days left in my holidays and after that it’s back to work. I’ve bought lots of stuff for you.\nYour sincerely,\nAmanda \nWhich statement is not mentioned in the text? \nA. Amanda is going to get over her vacation soon\nB. Amanda has prepared some souvenirs for Febriana\nC. Amanda and Febriana have gone on holiday\nD. Amanda misses Febriana\nE. Amanda has taken a vacation",
                "Amanda is going to get over her vacation soon",
                "Amanda has prepared some souvenirs for Febriana",
                "Amanda and Febriana have gone on holiday",
                "Amanda misses Febriana",
                "Amanda has taken a vacation",
                "Amanda and Febriana have gone on holiday");
        this.addQuestion(q25);
        Question q26 = new Question(3, 1, "Anwar\t: … he usually drink tea in the night?\nFandi\t: Yes, he does. \nA. Done \nB. Doing \nC. Do \nD. Does \nE. Did",
                "Done",
                "Doing",
                "Do",
                "Does",
                "Did",
                "Does");
        this.addQuestion(q26);
        Question q27 = new Question(3, 1, "\nRidho\t: Why do you prefer Sahabat Department Store to others?\nSindhu\t: because the items … at a reasonable price. \nA. had been sold \nB. were sold \nC. was sold \nD. are sold \nE. is sold",
                "had been sold",
                "were sold",
                "was sold",
                "are sold",
                "is sold",
                "are sold");
        this.addQuestion(q27);
        Question q28 = new Question(3, 1, "I used to have a beautiful cat named Proudy. She had white fluffy and purple eyes and she had a little gray spot on her head and a black spot on her tail, and she also had small legs with very cute paws.\nProudy was a very smart cat too. She knew my … (8). She would wake me up in the morning, a couple of minutes before my alarm clock rang. She even knew what time I came home. When I opened the door, she would jump on me … (9) as if she was trying to tell me that she missed me so much.\nProudy and I used to have great times together. Unfortunately last year she died … (10) a truck hit her. I buried her in our garden in front of my bedroom window. I really love and miss Proudy.\nA. business \nB. daily \nC. alarm \nD. plan \nE. schedule",
                "business",
                "daily",
                "alarm",
                "plan",
                "schedule",
                "schedule");
        this.addQuestion(q28);
        Question q29 = new Question(3, 1, "I used to have a beautiful cat named Proudy. She had white fluffy and purple eyes and she had a little gray spot on her head and a black spot on her tail, and she also had small legs with very cute paws.\nProudy was a very smart cat too. She knew my … (8). She would wake me up in the morning, a couple of minutes before my alarm clock rang. She even knew what time I came home. When I opened the door, she would jump on me … (9) as if she was trying to tell me that she missed me so much.\nProudy and I used to have great times together. Unfortunately last year she died … (10) a truck hit her. I buried her in our garden in front of my bedroom window. I really love and miss Proudy. \nA. quickly \nB. slowly \nC. lazily \nD. wildly \nE. idly",
                "quickly",
                "slowly",
                "lazily",
                "wildly",
                "idly",
                "quickly");
        this.addQuestion(q29);
        Question q30 = new Question(3, 1, "I used to have a beautiful cat named Proudy. She had white fluffy and purple eyes and she had a little gray spot on her head and a black spot on her tail, and she also had small legs with very cute paws.\nProudy was a very smart cat too. She knew my … (8). She would wake me up in the morning, a couple of minutes before my alarm clock rang. She even knew what time I came home. When I opened the door, she would jump on me … (9) as if she was trying to tell me that she missed me so much.\nProudy and I used to have great times together. Unfortunately last year she died … (10) a truck hit her. I buried her in our garden in front of my bedroom window. I really love and miss Proudy. \nA. although \nB. because \nC. however \nD. if \nE. but",
                "although",
                "because",
                "however",
                "if",
                "but",
                "because");
        this.addQuestion(q30);
        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LESSON_ID, quest.getID_LESSON());
        values.put(CHAP_ID, quest.getID_CHAPTER());
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        values.put(KEY_OPTE, quest.getOPTE());

        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public void addChapter(Chapter chapter) {
        ContentValues values = new ContentValues();
        values.put(LESSON_ID, chapter.getID_LESSON());
        values.put(CHAP_NUMBER, chapter.getCHAPTER_NUMBER());

        dbase.insert(TABLE_CHAPTER, null, values);
    }

    public void addLesson(Lesson lesson) {
        ContentValues values = new ContentValues();
        values.put(LESSON_NAME, lesson.getLESSON_NAME());

        dbase.insert(TABLE_LESSON, null, values);
    }

    public void addScore(Score score) {
        ContentValues values = new ContentValues();
        values.put(LESSON_ID, score.getID_LESSON());
        values.put(CHAP_ID, score.getCHAPTER_ID());
        values.put(SCORE_VALUE, score.getSCORE_VALUE());

        dbase.insert(TABLE_SCORE, null, values);
    }

    public List<Question> getAllQuestions(int lesson, int chapter) {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " WHERE " + LESSON_ID + " = " + lesson + " AND " + CHAP_ID + " = " + chapter;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setID_LESSON(cursor.getInt(1));
                quest.setID_CHAPTER(cursor.getInt(2));
                quest.setQUESTION(cursor.getString(3));
                quest.setANSWER(cursor.getString(4));
                quest.setOPTA(cursor.getString(5));
                quest.setOPTB(cursor.getString(6));
                quest.setOPTC(cursor.getString(7));
                quest.setOPTD(cursor.getString(8));
                quest.setOPTE(cursor.getString(9));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public ArrayList<HashMap<String, String>> getScore() {
        ArrayList<HashMap<String, String>> scoreList;
        scoreList = new ArrayList<HashMap<String, String>>();

        String selectQuery = "SELECT  * FROM score";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("lesson", cursor.getString(2));
                map.put("chapter", cursor.getString(3));
                map.put("score", cursor.getString(4));
                scoreList.add(map);
            } while (cursor.moveToNext());
        }

        return scoreList;
    }


}

