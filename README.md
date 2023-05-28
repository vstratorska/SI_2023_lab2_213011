# SI_2023_lab2_213011
Викторија Страторска 213011

Control Flow Graph 
![image](https://github.com/vstratorska/SI_2023_lab2_213011/assets/29504605/942706e8-254d-49b4-8440-4d6f6808d815)


Цикломатска комплексност Цикломатската комплексност на овој код е 11, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=10, па цикломатската комплексност изнесува 11. Истото го добиваме ако ја користеме и формулата (E-N)+2 каде Е е број на ребра и Е=39, а N е број на јазли и N=30, па од тука (39-30)+2=11


Тест случаи според критериумот Every branch 
![image](https://github.com/vstratorska/SI_2023_lab2_213011/assets/29504605/6811e107-f7d2-4659-9f22-e56998e02b59)


Test case1) user=null user.getPassword=null user.getEmail=null allUsers=anything Програмата ќе наиде на усклучокот RuntimeException и ќе терминира во јазел 2.

Test case2) user.getUsername()=null user.getPassword()=Strumicaa** user.getEmail()=viktorija.s@gmail.com allUsers={ (olivera, pasvord2233$, oli.vera@yahoo.com), (viktorija.s@gmail.com, Strumicaa**, viktorija.s@gmail.com) } Тест случајот ќе опфати повеќе гранки поради тоа што user.getUsername()==null и user.getEmail()==viktorija.s@gmail.com (содржи @ и .), од јазел 20 влегува во if бидејќи нема празно место во пасвордот, но ќе терминира во јазел 23 бидејќи во пасвордот ќе најде специјален знак.

Test case3) user.getUsername()=viksi user.getPassword()=pass123 user.getEmail()=mail.gmail.com allUsers=anything Програмата ќе терминира во јазел 19 бидејќки пасвордот има должина помала од 8.

Test case4)user.getUsername()=viksi user.getPassword()=12345 pass user.getEmail()=mail.gmail.com allUsers=anything Пасвордот содржи празно место па затоа од јазел 20 преминува во јазел 25 и не влегува во if.

Test case5) user.getUsername()=viksi user.getPassword()=pass12345 user.getEmail()=mail.gmail.com allUsers=anything Пасвордот не содржи празно место па затоа од јазел 20 влегува во if и поради тоа што нема специјални знаци не терминира во јазел 23.

Тест случаи според критериумот Multiple Condition Имаме 4 тест случаи според овој критериум.

Test case1) T || X || X
user=null Доколку user==null, другите два случаи не се важни бидејќи барањето во if е веќе исполнето.

Test case2) F || T || X user=new User("Viktorija", null, null) user.getPassword()=null Доколку постои user тогаш проверуваме дали user.getPassword()==null, ако да барањето во if е веќе исполнето и другиот случај не е важен.

Test case3) F || F || T user=new User("Viktorija", "pass12345", null) user.getPassword()=pass12345 user.getEmail()=null Доколку постојат user и user.getPassword() тогаш проверуваме дали user.getEmail()==null, ако да барањето во if е исполнето.

Test case4) F || F || F user=new User("Viktorija", "pass12345*", "viktorija.stra@gmail.com") user.getPassword()=pass12345* user.getEmail()=viktorija.stra@gmail.com Доколку постојат user, user.getPassword() и user.getEmail() тогаш барањето во if не е исполнето.


Објаснување на напишаните unit tests
Со напишаните unit тестови ги тестираме горенаведените случаи преку две функции. Во првата функција ги тестираме петте тест случаи од критериумот Every branch. Во првиот случај
очекуваме исклучок па затоа тестираме со помош на assert изразите assertThrows() и assertTrue(). Доколку при извршување на програмата ја добиеме пораката "Mandatory information missing!" 
тогаш тестот ни поминува точно. Во сите други случаи функцијата function треба да ни врати false (терминира во јазлите 19, 23 и 25 каде во јазел 23 проверува дали same == 0, а бидејќи во
нашиот случај same ќе стане 2 по проверката ќе се врати false) па затоа тестираме со изразот assertEquals() со очекувана повратна вредност false. 
Во втората функција ги тестираме четирите тест случаи од критериумот Multiple Condition. Во случај 1 2 и 3 тестираме со истите assert изрази како во првиот случај од претходната
функција. За последниот тест случај очекуваме функцијата function да врати true бидејќи во овој случај same ќе биде 0 (праќаме user со email кој содржи @ и . но кој не е во листата 
allUsers па затоа same од 1 ќе стане 0) и бидејќи пасвордот содржи специјални знаци при проверка на same == 0 функцијата ќе врати true. Затоа во овој тест случај тестираме со 
изразот assertEquals() со очекувана повратна вредност true.
