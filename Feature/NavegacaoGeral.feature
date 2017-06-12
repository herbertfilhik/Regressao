Feature: Navegacao Geral

Scenario: Navegacao Geral
	Given Usuário está na página
	When Usuário faz login na página
	And usuário digita usuário e senha
	Then exibe mensagem de sucesso do login
	Then usuário navega pelos menus	
	When usuário efetua logout
	Then mensagem ao usuário informando o logout com sucesso