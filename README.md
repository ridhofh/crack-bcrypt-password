# crack-hash-bcrypt

## Disclaimer

>All the information provided on this tutorial is for educational purposes only. The information on this tutorial should only be used to enhance the security for your computer systems and not for causing malicious or damaging attacks.
>
>You should not misuse this information to gain unauthorized access into computer systems. Also be aware, performing hack attempts on computers that you do not own, without written permission from owners, is illegal.
>
>PT Dymar Jaya Indonesia will not be responsible for any direct or indirect damage caused due to the usage of the information provided on this tutorial.
---
>Semua informasi yang diberikan pada tutorial ini bertujuan untuk edukasi. Informasi pada tutorial ini sebaiknya hanya digunakan untuk meningkatkan keamanan sistem komputer Anda dan bukan untuk menyebabkan serangan jahat atau merusak.
>
>Anda tidak boleh menyalahgunakan informasi ini untuk mendapatkan akses tidak sah ke sistem komputer. Ketahuilah bahwa, melakukan upaya peretasan pada komputer yang bukan milik Anda, tanpa izin tertulis dari pemilik, adalah ilegal.
>
>PT Dymar Jaya Indonesia tidak akan bertanggung jawab atas kerusakan langsung atau tidak langsung yang disebabkan karena penggunaan informasi yang diberikan pada tutorial ini.
<br>

## Deskripsi
Crack Bcrypt dengan pendekatan dictionary attack. Zaman ini dictionary password yang cukup akurat sangat mudah didapat dari internet ataupun dibuat dengan teknologi Artificial Intelligence (AI).
<br>

## Contoh Penggunaan

### Untuk bahasa pemrograman Java masuk ke folder `crack-bcrypt\java-bcrypt`.

Generate bcrypt hash dari password.
```
Usage: java bcrypttest <Data>

crack-bcrypt\java-bcrypt>java bcrypttest p@ssw0rd
data: p@ssw0rd
prefix: 2a
log round: 10
salt: 4OreeNQ2jLnjD5wxmkiXru
hash: MjuDuFpLGUmAIDjcJ13y4f7gxlwEjZC
bcrypt: $2a$10$4OreeNQ2jLnjD5wxmkiXruMjuDuFpLGUmAIDjcJ13y4f7gxlwEjZC
```

Brute force bcrypt password menggunakan list kamus/dictionary.
```
Usage: java bfda <Dictionary File Name> <Bcrypt Hash>

crack-bcrypt\java-bcrypt>java bfda dictionary.txt $2a$10$4OreeNQ2jLnjD5wxmkiXruMjuDuFpLGUmAIDjcJ13y4f7gxlwEjZC
p@ssw0rd
```

Mencari password dari suatu list bcrypt password.
```
Usage: java sdbm <Bcrypt Database File Name> <Clear Password>

crack-bcrypt\java-bcrypt>java sdbm db.txt P@ssw0rd
$2a$10$gCOjiyIlrHDr.tYAvB1kdu32RiEl9LqKJh7mkIJEIMdjGC7SWM7nK
$2a$10$498jf/EdrFirxtGGdsfOZOEze5eATdJRBojDP6UgIMTQBEb.yWtaa
$2a$10$I/yNzTkgBSHfleHPMa3kw.Cl7LwASHdE/Gxw/pXoTeYHyGMGtKSjW
```

Mencari password berdasarkan dictionary terhadap list bcrypt password.
```
Usage: java mnm <Bcrypt Database File Name> <Dictionary File Name>

crack-bcrypt\java-bcrypt>java mnm db.txt dictionary.txt
$2a$10$ApnuWv1YaPVOWMccxk8nUeVbpOXyk6g1HG67KpozOb0AH11nPJqa2:password
$2a$10$YpDyZ3qGVBFuFAe/XQObeu5XIGRLeDa4VmREGlBkIxfledUd4GQUi:test
$2a$10$gCOjiyIlrHDr.tYAvB1kdu32RiEl9LqKJh7mkIJEIMdjGC7SWM7nK:P@ssw0rd
$2a$10$498jf/EdrFirxtGGdsfOZOEze5eATdJRBojDP6UgIMTQBEb.yWtaa:P@ssw0rd
$2a$10$I/yNzTkgBSHfleHPMa3kw.Cl7LwASHdE/Gxw/pXoTeYHyGMGtKSjW:P@ssw0rd
$2a$10$FMniiwyewiiQDcPZz26X9eOIchXktWO8kBciEEqmx1qRuOA2m7WRO:SecretPassword
$2a$10$jx/qQe.pDuX2h0i9QVyzSOQUQ.P.hDdQQoeC1x1pVUNoQw5A/jaUi:rahasia123
```

### Untuk bahasa pemrograman Golang masuk ke folder `crack-bcrypt\golang-bcrypt`.

Generate bcrypt hash dari password.
```
Usage: bcrypttest.exe <data>

crack-bcrypt\golang-bcrypt\bcrypttest>bcrypttest.exe P@ssw0rd
data:  P@ssw0rd
prefix: 2a
log rounds:  10
salt:  Yp1tDRQN.8GWov8cRst1MO
hash:  gtB8y35MUgPwERmuk5c5VSg8JErGMQq
bcrypt:  $2a$10$Yp1tDRQN.8GWov8cRst1MOgtB8y35MUgPwERmuk5c5VSg8JErGMQq
```

Brute force bcrypt password menggunakan list kamus/dictionary.
```
Usage: bfda.exe <dictionary bcrypt file name> <bcrypt hash>

crack-bcrypt\golang-bcrypt\bfda>bfda.exe dictionary $2a$10$Yp1tDRQN.8GWov8cRst1MOgtB8y35MUgPwERmuk5c5VSg8JErGMQq
P@ssw0rd
```

Mencari password dari suatu list bcrypt password.
```
Usage: sdbm.exe <bcrypt database file name> <clear password>

crack-bcrypt\golang-bcrypt\sdbm>sdbm.exe db P@ssw0rd
$2a$10$gCOjiyIlrHDr.tYAvB1kdu32RiEl9LqKJh7mkIJEIMdjGC7SWM7nK
$2a$10$498jf/EdrFirxtGGdsfOZOEze5eATdJRBojDP6UgIMTQBEb.yWtaa
$2a$10$I/yNzTkgBSHfleHPMa3kw.Cl7LwASHdE/Gxw/pXoTeYHyGMGtKSjW
```

Mencari password berdasarkan dictionary terhadap list bcrypt password.
```
Usage: mnm.exe <bcrypt database file name> <dictionary file name>

crack-bcrypt\golang-bcrypt\mnm>mnm.exe db dictionary
$2a$10$FMniiwyewiiQDcPZz26X9eOIchXktWO8kBciEEqmx1qRuOA2m7WRO:SecretPassword
$2a$10$jx/qQe.pDuX2h0i9QVyzSOQUQ.P.hDdQQoeC1x1pVUNoQw5A/jaUi:rahasia123
$2a$10$gCOjiyIlrHDr.tYAvB1kdu32RiEl9LqKJh7mkIJEIMdjGC7SWM7nK:P@ssw0rd
$2a$10$ApnuWv1YaPVOWMccxk8nUeVbpOXyk6g1HG67KpozOb0AH11nPJqa2:password
$2a$10$498jf/EdrFirxtGGdsfOZOEze5eATdJRBojDP6UgIMTQBEb.yWtaa:P@ssw0rd
$2a$10$I/yNzTkgBSHfleHPMa3kw.Cl7LwASHdE/Gxw/pXoTeYHyGMGtKSjW:P@ssw0rd
$2a$10$YpDyZ3qGVBFuFAe/XQObeu5XIGRLeDa4VmREGlBkIxfledUd4GQUi:test
```

## Solusi
Sangat direkomendasikan untuk mengenkripsi password yang akan disimpan di database menggunakan kriptografi simetrik key misalnya dengan algoritma AES. Kemudian amankan simetrik key tersebut menggunakan hardware khusus kriptografi tersertifikasi yaitu HSM (Hardware Security Module) seperti [payShield 10K HSM](https://dymarjaya.co.id/product/payshield-10000/). Hal ini dilakukan untuk mengupayakan keamanan dalam proteksi data atau aset berharga perusahaan.
Untuk informasi bagaimana mengintegrasikan aplikasi dengan HSM, dapat mengunjungi [repository](https://github.com/dymarjaya/payshield-hsm-api) berikut ini. Untuk informasi lebih lanjut dapat menghubungi [Dymar](https://www.dymarjaya.co.id).
