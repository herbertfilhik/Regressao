Feature: Navegacao Dashboard

Scenario: Navegacao Dashboard
	Given Usuário está na página Dashboard
	When Usuário faz login na página Dashboard
	And usuário digita usuário e senha Dashboard
	Then exibe mensagem de sucesso do login Dashboard
	Then usuário navega até o menu Dashboard
	Then usuário valida itens da tela e seus acessos Dashboard
	When usuário efetua logout Dashboard
	Then mensagem ao usuário informando o logout com sucesso Dashboard