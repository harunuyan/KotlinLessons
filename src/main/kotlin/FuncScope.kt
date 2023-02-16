/*
Scope Functions

fun main(){
    var bankAccount= BankAccount(
        23432.32.toBigDecimal(),
        "harun"
    )
    if(bankAccount != null && bankAccount.accountName != null){
        println(bankAccount.accountName)
    }
}


bankAccount.let{ it:BankAccount // Temel kullanım amacı null check yapmaktır. Nesnesi nulable oluşturulmuş bir nesne üzerinde işlem yapılacaksa kullanılır.
    if(it != null && it.accountName != null){
        println(it.accountName)
    }
}

with(bankAccount){ this:BankAccount // Nullable olmayan nesnesi oluşturulmuş bir değişkenle işlem yapılacaksa kullanılır.
    if(this != null && this.accountName != null){
        println(this.accountName)
    }
}

bankAccount.run{ this:BankAccount //with ile let'in birleşimi gibidir. İşlemler bittiğinde, ya da tamamane haricen bir işlem çalıştırmak üzere çağırılır. }.run {} . Bir T ye bağımlı olmak zorunda değildir tek başına da
    if(this != null && this.accountName != null){     // çağırılabilir. Çalıştırılabilir işlemleri içeren bir scope yaratmış oluruz.
        println(this.accountName)
    }
}
run{

}

bankAccount.also{ it:BankAccount // Genelde let ya da with'in sonuna yazılır. let ve with ile işlem yaptıktan sonra "harici olarak bir de bunların dışında bunları yap" demek gibidir.
    if(it != null && it.accountName != null){  // Genelde bu tarz başlangıç yapısında kullanılmazlar. }.also{} şeklinde çağırılırlar.
        println(it.accountName)
    }
}

bankAccount.apply{ this:BankAccount // Henüz elimizde değişkenin değeri olmadığında ve apply body'si içerisinde değer atayacaksak kullanılır. Parametrelerin constructor'da olmaması gerekir.
    if(this != null && this.accountName != null){
        println(this.accountName)
    }
}





data class BankAccount(
    val accountBalance: BigDecimal?
    val accountName : String?,
)*/
