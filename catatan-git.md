Endy Muhardin
endy.muhardin@gmail.com
http://software.endy.muhardin.com

# Version Control #

* Menyimpan file dan folder
* Bisa diakses orang banyak
* Akses kontrol
* Konsolidasi perubahan
* History perubahan
* Restore versi yang terdahulu
* Membatalkan perubahan tertentu
* Paralel development

# Jenis-jenis Version Control

* Centralized
    
    * Database terpusat
    * Perubahan submit ke server
    * Ketika submit, harus terkoneksi dengan server
    * Cuma bisa 1 macam workflow

* Distributed

    * Database masing-masing orang
    * Perubahan submit ke database lokal
    * Submit perubahan tidak perlu koneksi kemana-mana
    * Database lokal bisa disinkronisasi dengan database terpusat
    * Bisa macam-macam workflow
    
# Macam-macam produk/aplikasi version control

* Centralized

    * CVS (open source)
    * Subversion (open source)
    * MS Source Safe (proprietary)

* Distributed

    * [Git](http://git-scm.com/)
    * [Mercurial](http://mercurial.selenic.com/)
    * [Bazaar](http://bazaar.canonical.com/en/)
    * [Bitkeeper (proprietary)](http://www.bitkeeper.com/)

# Macam-macam layanan version control (project hosting)

* [Sourceforge](http://sourceforge.net/)
* [Google Code](https://code.google.com)
* [Github](https://github.com)
* [Bitbucket](https://bitbucket.org)

# Git

* Awalnya dibuat oleh Linus Torvalds
* Karena konflik dengan Bitkeeper

# Git Server

* Gitolite (python, text-based)
* Gitblit (java, web-based)
* Gitlab (ruby, web-based)

# Git Client

* git command line
* Git Gui
* Gitg
* TortoiseGit (windows explorer integration)

# Protokol Komunikasi

* File lokal / Windows File Sharing
* HTTP
* SSH

# Setup Git di Windows

* Download dan Install
* Generate public dan private key

    * Buka command prompt Git Bash (klik kanan Windows Explorer > Git Bash)
    * Jalankan perintah `ssh-keygen`
    * Periksa folder `C:\Users\NamaUser\.ssh`, cari file `id_rsa` (private key) dan `id_rsa.pub` (public key)

# Mendaftarkan SSH Public Key di Github

* Login ke Github
* Masuk ke halaman Settings
* Klik tab SSH Keys
* Copy-paste isi public key yang sudah dibuat di langkah sebelumnya (`id_rsa.pub`)

# Membuat Repository Git

* Buat folder kosong
* Jalankan `git init` di dalam folder tersebut
* Hasilnya : akan terbentuk folder dengan nama `.git`

# Perintah Dasar

* git diff : melihat perubahan dari versi yang terakhir dicommit (yang berada di working area)
* git diff --staged : melihat perubahan yang ada di staging area
* git add : menambahkan / mendaftarkan perubahan yang akan dicommit
* git commit : menyimpan perubahan ke database

# Beberapa Istilah

* Repository : database yang berisi daftar perubahan
* Staging Area : perubahan yang *akan* di-commit
* Working Area : perubahan yang kita lakukan dan belum dimasukkan ke staging
* Remote : repository di komputer lain (misalnya dalam server di internet)

# Remote Repository

* Mendaftarkan remote repo : `git remote add <nama remote> <url>`
* Upload ke remote : `git push <nama remote> <nama branch>`
* Copy repo ke local (pertama kali saja) : `git clone <url>`
* Download perubahan terbaru dari remote : `git pull`

# Belajar Workflow di Git

* Shared Repository : semua orang push ke repo yang sama
* Integration Manager : hanya IM yang push ke repo utama

# Workflow Integration Manager : Contributor

* Fork Repo Induk
* Clone dari hasil fork
* Setup remote `upstream` yang mengarah ke repo induk
* Lakukan perubahan
* Push ke hasil fork

