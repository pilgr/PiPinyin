PiPinyin
--------

PiPinyin is a simple android library supporting convertion between Chinese characters and Pinyin system

Originally based on [pinyin4android][1]

How to use
----------
```java
final PiPinyin piPinyin = new PiPinyin(this);
piPinyin.toPinyin("这是一个测试", " ");
piPinyin.toShortPinyin("这是一个测试");
piPinyin.toPinyin('我');
piPinyin.recycle();
```

License
-------

    Copyright 2014 Aleksey Masny

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [1]: https://code.google.com/p/pinyin4android/