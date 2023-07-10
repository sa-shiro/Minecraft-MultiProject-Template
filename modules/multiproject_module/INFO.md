original source:
    https://github.com/jaredlll08/MultiLoader-Template

if you change the name of this module, make sure to also change   
`:modules:multiproject_module:common`
from `fabric/build.gradle` and `forge/build.gradle` to your new module name

to include common resources in the Forge Data Generator , add the following line to args:
`'--existing', file('../common/src/main/resources/')` to the `data` task