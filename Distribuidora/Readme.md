# Apartado 1

```mermaid
classDiagram

class Formulario
    Formulario: +procesar()
    Formulario: +Collection~FormField~ getData()

class FormularioProcesor
    FormularioProcesor: +FormularioProcesor(Formulario formulario)
    FormularioProcesor: +formulario
    FormularioProcesor: +commandFactory
    FormularioProcesor: +Formulario getForm()
    FormularioProcesor: +process()

class FormularioPedido
    FormularioPedido: +SetFormularioFormField(WareHouseFormField)
    FormularioPedido: +List~WareHouseFormField~ WareHouseFormFields
    FormularioPedido: +validate()

class Command
    <<interface>> Command
    Command : +execute()

class SendToWareHouseCommand
    SendToWareHouseCommand : +form
    SendToWareHouseCommand: +SendToWareHouseCommand(form)
    SendToWareHouseCommand: +execute()
class FormField
    <<interface>> FormField
    FormField: +isValid()

class WareHouseFormField
    WareHouseFormField: +isValid()


class CommandFactory
    CommandFactory: +Command createCommand(formulario)

FormularioPedido --> WareHouseFormField
FormularioProcesor --> CommandFactory
FormularioProcesor --> Formulario
CommandFactory --> Command
SendToWareHouseCommand --|>Command
SendToWareHouseCommand --> Formulario
FormField <|-- WareHouseFormField
Formulario <|-- FormularioPedido
```
# Apartado 
```mermaid
sequenceDiagram
    App ->> FormularioPedido : new()
    FormularioPedido -->> App : formularioPedido
    
    App->>FormularioProcessor: new FormularioProcesor(Formulario formularioPedido)
    FormularioProcessor --> CommandFactory:new()
    CommandFactory -->> FormularioProcessor : commandFactory
    FormularioProcessor -->> App: formularioProcessor
    App ->> FormularioProcessor: process()
    FormularioProcessor ->> CommandFactory: CreateCommand(form)
    CommandFactory ->> SendToWareHouseCommand : new SendToWareHouseCommand(form)
    SendToWareHouseCommand -->> CommandFactory : SendToWareHouseCommand command
    CommandFactory -->> FormularioProcessor: Command command
    FormularioProcessor ->> SendToWareHouseCommand : execute()
    SendToWareHouseCommand ->> FormularioPedido : getData()
    FormularioPedido -->> SendToWareHouseCommand : formField
   ```
