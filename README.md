# Overview

`watchtower-monitoring` is part of `watchtower`. Its primary role is to get and forward events from the monitoring solutions to `watchtower-workflow`

### Build Instructions

The best way to install `watchtower-monitoring` is to download and build it with Maven. Please note you need to download and install `monasca-common` beforehand.

```
git clone https://github.com/icclab/watchtower-monitoring.git
cd watchtower-monitoring
mvn clean package
```

# License

Copyright 2015 Zurich University of Applied Sciences

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied.
See the License for the specific language governing permissions and
limitations under the License.