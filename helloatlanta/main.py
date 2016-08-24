#!/usr/bin/env python
#
# Copyright 2007 Google Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
import webapp2

html = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Form Example</title>
</head>
<body>
    <h1>Account details</h1>
    <form method="post">
        <label for="firstName">First Name: </label>
        <input name="firstName" type="text" value"">
        <br>
        <label for="familyName">Family Name: </label>
        <input name="familyName" type="text" value="">
        <br>
        <input name="" type="submit" value="Save">
    </form>
</body>
</html>
"""


class MainHandler(webapp2.RequestHandler):
    def get(self):
        self.response.write(html)

    def post(self):
        firstName = self.request.get("firstName")
        familyName = self.request.get("familyName")
        self.response.out.write("First Name: " + firstName + "\n" + "Family Name: " + familyName)


app = webapp2.WSGIApplication([
    ('/', MainHandler)
], debug=True)
