INICIO: 22/08/2023 ~ FIM: 

Link do Curso:
https://gbtech.udemy.com/course/kotlin-spring
...............................................................................................................................................................................................................
########### AULA -> WHEN -> CASE EM JAVA ######################################
https://gbtech.udemy.com/course/kotlin-spring/learn/lecture/26339450#overview

fun comecaComOi(x: Any): Boolean {
	return when(x) {
		is String -> x.startsWith("oi")
		else -> false
	}
}

Explicando:
> linha 9:  Recebe uma variavel do tipo "QUALQUER", pode ser Int, String, Double, Boolean ... E retorna um Boolean (true/false)
> linha 10: Retorno da função é um WHEN que ira compara o valor recebido como paramentro pela função
> linha 11: Compara se o parametro recebido é do tipo String. Se for uma String então valida de o valor do parametro recebido inicia com a String "oi". Se atender ao requisiro retorna TRUE
> linha 12: Caso o parametro não for uma String e não inicie com a String "oi" então ira retornar FALSE
...............................................................................................................................................................................................................

fun funcionalidadesWhen(val x: Int) {
	when(x) {
		5 -> println("eh cinco")
		8, -8 -> printnl("eh oito")
		9 -> {
				println("eh nove")
				println("mais um e fica dez")
			}
		in 10 .. 15 -> println("esta entre 10 e 15")
		!in 20 .. 30 -> println("não esta entre 20 e 30")
		else -> println("Numero não mapeado")
	}
}

Explicando:
> Varios tipos de retorno e utilidades do when em Kotlin

...............................................................................................................................................................................................................
######################## AULA -> NULL SAFETY ################################
https://gbtech.udemy.com/course/kotlin-spring/learn/lecture/26339458#overview

> Declarar Variaveis que podem ser NULL

	var nomeNaoNulo: String = "Luffy"
	println(nome.length)
	
	var nomeErro: String = null
	println(nome.length) //ERROR
	
	var nomeNulo: String? = null
	println(nome?.length)
	println(nome?.length?.toShort())
	
	//ELVIS OPERATOR
	var nomeE: String = null
	var tamanhoErro: Int 	= nomeE?.length 	//ERROR
	var tamanho: Int 		= nomeE?.length ?: 0
	
Explicando:
> linha 50: A variavel não foi declarada com ? logo não é possivel extrair o tamanho de uma string nula. O compilador vai informar o erro
> linha 53: Eh o cenario de correção da linha 50. Ao declarar a variavel com ? e ao ler a variavel usamos o ? assim tambem para pegar o tamanho da string usamos ?
> linha 59: Usamos o ELVIS operator para validar se a variavel é nula ou não. Neste caso se a variavel for nula será retornado o valor 0. ELVIS pode retornar qualquer tipo de variavel ou até mesmo chamar uma função!

...............................................................................................................................................................................................................
######################## AULA -> Collections ################################
https://gbtech.udemy.com/course/kotlin-spring/learn/lecture/26339462#overview

	var lista = listOf(1, 2, 3, 4, 5, 6)
	
	var listaMut = mutableListOf(1, 2, 3, 4, 5, 6)
	
	lista.forEach{
		println(it)
	}
	
	for (numero in lista) {
		println(numero)
	}
	
	lista.sort()
	
	lista.shuffle()
	
	var listaSet = setOf(2, 4, 6, 8)
	
	var listaSetM = mutableSetOf(1, 3, 5, 7)
	
	var listaMap = mapOf("Jonis" to 34, "Brunna" to 33, "Anna Julia" to 13, "Alice" to 4)
	
	var listaMap = mutableMapOf("Jonis" to 34, "Brunna" to 33, "Anna Julia" to 13, "Alice" to 4)
	
	listaMap["Noah",0]
	
	listMap.put("Noah",0)
	
Explicando:
> linha 70: Declarando uma lista, sempre que declarado com listOf() e a lista é IMUTAVEL, não pode ser alterada.
> linha 72: Declarando uma lista que pode ser alterada, éh possivel fazer um listaMut.add(10)
> linha 74: Como iterar uma lista com "foreach". "it" representa um item da lista
> linha 78: Como iterar uma lista com "for"  
> linha 82: Como ordenar uma lista
> linha 84: Como embaralhar os itens de uma lista
> linha 86: Como criar uma lista do tipo "set" esta não permite itens duplicados
> linha 90: Declarando um "map" imutavel. Não permite itens com chaves iguais
> linha 92: Declarando um "map" editavel. Não permite itens com chaves iguais
> linha 94: Incluindo ou Editando o item de um map
> linha 96: Incluindo um novo item no map	
	
	
	