# Copyright 2018 Google Inc.
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FROM debian:buster-slim

ENV GRAAL_VERSION 1.0.0-rc2

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

RUN cd /opt && curl -L https://github.com/oracle/graal/releases/download/vm-${GRAAL_VERSION}/graalvm-ce-${GRAAL_VERSION}-linux-amd64.tar.gz | tar -xz
RUN ln -sf /opt/graalvm-ce-${GRAAL_VERSION} /opt/graal

ENV PATH $PATH:/opt/graal/bin

ENTRYPOINT ["native-image"]
