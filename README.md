**acces_token for github registry** is this 

`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`

add this to CR_PAT variable as so:

`export CR_PAT=YOUR_TOKEN`

or `set CR_PAT=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` on windows 

then `docker login -u USERNAME -p %CR_PAT% docker.pkg.github.com` 

