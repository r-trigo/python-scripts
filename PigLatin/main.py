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

html = """<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Pyg Latin</title>
        </head>
        <body>
        <form method="post" >
            Type your word:
            <input type="text" name="word" placeholder="Type your word" autofocus required="required">
            <br>
            <input type="submit" name="submit" value="Translate!">
        </form>
        </body>
        </html>"""


class MainHandler(webapp2.RequestHandler):
    """def get(self):
        self.response.write("Hello Atlanta")"""

    def get(self):
        self.response.write(html)

    def post(self):
        pyg = 'ay'

        original = self.request.get('word')

        if len(original) > 0 and original.isalpha():
            word = original.lower()
            first = word[0]
            new_word = word + first + pyg
            new_word = new_word[1:len(new_word)]
            self.response.write(new_word)
        else:
            self.response.write("Invalid word")


app = webapp2.WSGIApplication([
    ('/', MainHandler)
], debug=True)
