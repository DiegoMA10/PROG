
## Diálogo de confirmación

```java
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Diálogo de confirmación");
alert.setHeaderText("Cabecera");
alert.setContentText("¿Seguro que quieres continuar?");
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK){
System.out.println("OK");
} else {
System.out.println("CANCEL");
} 

```
## Diálogo de confirmación personalizado 

```java
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Diálogo de confirmación");
alert.setHeaderText("Este diálogo tiene acciones personalizadas");
alert.setContentText("Elige una opción");
ButtonType buttonTypeOne = new ButtonType("Uno");
ButtonType buttonTypeTwo = new ButtonType("Dos");
ButtonType buttonTypeThree = new ButtonType("Tres");
ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree,
buttonTypeCancel);
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent()) {
if (result.get() == buttonTypeOne)
System.out.println("Uno");
else if (result.get() == buttonTypeTwo)
System.out.println("Dos");
else if (result.get() == buttonTypeThree)
System.out.println("Tres");
else
System.out.println("Cancelar");
}
```

## Diálogo de entrada de texto 

```java
TextInputDialog dialog = new TextInputDialog("Pepe"); // Por defecto
dialog.setTitle("Diálogo de entrada de texto");
dialog.setHeaderText("Cabecera");
dialog.setContentText("Introduce tu nombre:");
Optional<String> result = dialog.showAndWait(); // Obteniendo el resultado
if (result.isPresent()){
System.out.println("Hola " + result.get());
// Obteniendo el resultado con una lambda
result.ifPresent(name -> System.out.println("Hola " + name));
}
```

## Diálogo de selección

```java
List<String> choices = new ArrayList<>();
choices.add("uno");
choices.add("dos");
choices.add("tres");
ChoiceDialog<String> dialog = new ChoiceDialog<>("dos", choices);
dialog.setTitle("Diálogo de selección");
dialog.setHeaderText("Cabecera");
dialog.setContentText("Elige un número:");
Optional<String> result = dialog.showAndWait();
if (result.isPresent()){
System.out.println("Has elegido: " + result.get());
// Obteniendo el resultado con una lambda
result.ifPresent(numero -> System.out.println("Has elegido: " + numero));
}

```

## Diálogo de error con Excepción

```java
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Diálogo de excepción");
alert.setHeaderText("Cabecera");
alert.setContentText("Se ha producido un error");
Exception ex = new FileNotFoundException("Detalles del error"); //Error forzado
//Formato de una excepción desplegable
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
ex.printStackTrace(pw);
String exceptionText = sw.toString();
Label label = new Label("Excepción:");
TextArea textArea = new TextArea(exceptionText);
textArea.setEditable(false);
textArea.setWrapText(true);
textArea.setMaxWidth(Double.MAX_VALUE);
textArea.setMaxHeight(Double.MAX_VALUE);
GridPane.setVgrow(textArea, Priority.ALWAYS);
GridPane.setHgrow(textArea, Priority.ALWAYS);
GridPane expContent = new GridPane();
expContent.setMaxWidth(Double.MAX_VALUE);
expContent.add(label, 0, 0);
expContent.add(textArea, 0, 1);
// Introduce
alert.getDialogPane().setExpandableContent(expContent);
alert.showAndWait();
```