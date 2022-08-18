---
id: 5nkpkkxgt8m9208wc9jyiom
title: Mockito
desc: ''
updated: 1660491136796
created: 1660490901665
---
```java
@Mock
View view;
@Mock
Model model;

@Test
public void testpresenter() {
    when(view.getUsername()).thenReturn("abc");
    when(model.isFound("abc")).thenReturn(true);
    Presenter presenter = new Presenter(modele, view);
    prsenter.checkUsername();
    InOrder order = inOrder(model,view);
    // order.verify(model).isFound(anyString());

    // verify(view).displayMessage("user found");

    order.verify(model).isFound("abc");
    order.verify(view).displayMessage("user found");
}
```