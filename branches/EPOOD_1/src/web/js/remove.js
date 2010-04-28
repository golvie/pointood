function removeCheckedItems() {
  var items = [];
  var productCheckboxForms = document.getElementsByName("productCheckboxForm");

  for ( var i = 0; i < productCheckboxForms.length; i++) {
    if (productCheckboxForms[i].productCheckbox.checked) {
      items.push(productCheckboxForms[i].productCheckbox.value);
    }
  }
  if (items.length == 0) {
    alert("You have nothing selected!");
  } else {

    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "c?mode=cart");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "checkedProducts");
    hiddenField.setAttribute("value", items.toString());

    form.appendChild(hiddenField);
    document.body.appendChild(form);
    form.submit();
  }
}