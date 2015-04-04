[![Build Status](https://travis-ci.org/carlo-mr/concordion-collapse-output-extension.svg?branch=master)](https://travis-ci.org/carlo-mr/concordion-collapse-output-extension)

This [Concordion](http://www.concordion.org) extension allows to specify that parts of the specification should be collapsible in the result page.


# Introduction

If you have parts of the specification (e.g. test pre-requisites/setup parts) which are not crucial for the specification you can add the _"collabsible"_ style class to the element and this extension will add a link, javascript and css to allow to collapse and expand this element. 

# Usage

1. Add the style class to the element.
  ```html
<div id="id" class="collapsible">This should be collapsible.</div>
  ```
  
2. Add the CollapseOutputExtension to your fixture

```code

@RunWith(ConcordionRunner.class)
@Extensions(CollapseOutputExtension.class)
public class Fixture {

}
```

A live example can be found [here](http://carlo-mr.github.io/concordion-collapse-output-extension/spec/spec/concordion/ext/collapse/usage/Usage.html)

# [Test Output](http://carlo-mr.github.io/concordion-collapse-output-extension/spec/spec/concordion/ext/collapse/Collapse.html)
