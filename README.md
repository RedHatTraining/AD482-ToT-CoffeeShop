# A Man, called Kafka, walks into a coffee shop and...


> ## Pre-Demo Preparations
>
> ### Install/Prepare the prereqs:
>
> * A running Openshift/Kubernetes cluster
>
> * Strimzi Kafka CLI:
>
> `sudo pip install strimzi-kafka-cli`
>
> * `oc` or `kubectl`
>
> Login to a Kubernetes or OpenShift cluster and create a new namespace/project called `reactive-coffeeshop-demo`.
>
> `oc new-project reactive-coffeeshop-demo`
>
> ### Install Apicurio Registry:
>
> You have two options for this:
>
> * Follow the instructions [here](https://access.redhat.com/documentation/en-us/red_hat_integration/2020-q4/html/getting_started_with_service_registry/installing-registry-ocp)
> * Or follow this [guide](https://www.apicur.io/registry/docs/apicurio-registry/2.0.0.Final/getting-started/assembly-installing-registry-openshift.html)
>
> In the end you should have an Apicurio Registry up and running in the same namespace, with an accesible Route URL like the following:
>
> `http://example-apicurioregistry.reactive-coffeeshop-demo.apps.naxx-stage2.dev.nextcle.com/ui/artifacts`
>
> ### Install Strimzi Operator
>
> `Skip this part if an operator is already installed in your Openshift/Kubernetes cluster.`
>
> ```shell
>  kfk operator --install -n reactive-coffeeshop-demo
> ```
>
> After that, the operator is installed you can create a cluster:
>
> <!-- Prereq: https://github.com/systemcraftsman/strimzi-kafka-cli/issues/72 -->
> ```shell
>  kfk clusters --create --cluster my-cluster --add-listener --listener-name external --listener-port 9094 --listener-type route --listener-tls true  -n reactive-coffeeshop-demo -y
> ```
>
## The Coffee Shop

It's been a hard year because of the pandemic, and when you learn the lockdown is over, you want to go to the coffee shop you used to go before pandemic.

<img width="604" alt="Screen Shot 2021-04-24 at 16 14 40" src="https://user-images.githubusercontent.com/10568159/120249950-2e68ef80-c285-11eb-9bd6-c52ada97ab6a.png">

It will be seen as the same old coffee shop, but not be sure about that so much, you will see a lot changed.

> First clone the `reactive-coffeeshop-demo` repository:
>
> ```shell
> git clone https://github.com/systemcraftsman/reactive-coffeeshop-demo.git
> ```
>
> And don't forget to checkout the `original` repo. That's where we are gonna start:
>
> ```shell
> cd reactive-coffeeshop-demo
> 
> git checkout original
> ```
>
> After switching to the right branch, you need to specify the
>
> Now run the `cofeeshop-service` and `barista-quarkus-http` service which are Quarkus applications.
>
> First run the `coffeeshop-service`:
>
> ```shell
>  cd cofeeshop-service
> ```
>
> In another terminal window, run the `barista-quarkus-http` service:
>
> ```shell
>  cd cofeeshop-service
> ```
>

You want to order a favorite of yours, "frappucino" and a barista you know "Isla" takes care of your order.

> TODO: Instructions and image here

"Ready" she says. "Gracias!" you say in return and enjoy your drink.

About an hour or so, you want to order another one. Isla is still there and ready take care of your order,
but she can not fulfill your request somehow.

> TODO: image here

When you ask this to her, she simply says:

"I have a preparation time around 5 seconds, but this coffee shop has strict rules on preparing the beverage in 1.5 seconds.
So I have to either prepare it in 1.5 seconds or never."

> TODO: Code explanation here

"What!" you say, "even 5 seconds is very fast to prepare a beverage it must be harsh to work here."

"Yes" she says "we can not even go for a rest happily! When I go for a rest and a collegue of mine comes your orders in this timeframe will not be processed.
You should order again".

"Well that's weird" you think and Isla goes for a rest.
You order your beloved frappucino again, again and again, but it fails, fails and fails.

> TODO: Image here

You see another barista is coming up for the shift, and make your order.
After about 10 times or so, the new barista Zoe, could prepare your order within just 1.5 seconds!

"This is a very big problem" you think. But who you are gonna call? Ghostbusters? A-team? MacGyver?

> TODO: Image A-team photo here

While thinking about all these and taking a sip of your frappucino (you are trying to drink it slowly this time),
a man with a fedora hat, who will introduce himself later as "Kafka", walks into the coffee shop and sits beside you.

Orders a "Chai" -actually by trying a couple of times- and faces the same problem.
He says "I know how to solve this problem" and gathers up all the baristas and the coffee shop manager himself for probably a "rule" change.

A couple of hours later the solution he comes up with is: using the `Messaging/Kafka` order method.

> TODO: Create topics here
> TODO: Run one of the kafka baristas

They wanted you to try it out, and you ordered a latte this time. Actually a lot of lattes.

And each handled by a group of baristas successfully.
You even tried to order some when they are all resting.

The order did not fail and when they came back you saw your order is prepared successfully without needing to make another one.

You ask Mr. Kafka what kind of change specifically he did.
Did he change the rule? Are these baristas new?
Do they work differently?

"No" he says. "They still can prepare a beverage in about 5 seconds, but now it does not make the order fail, now my order methods is being used,
I provide an async, persisted mechanism; let's call this `even-driven coffee ordering`.
You make the order, and the baristas prepare it depending on who is available".

Kafka solved a lot of problem in this case. He simply provided an event backbone, so that the orders can be handled seamlessly.

Looking around peacefully you realize a kind of fight or war outside.
The door was open and you see a old white car with a ghost sign on it.
"OMG, the Ghostbusters" people say.
You think someone should've call them in the previous situation because you realize you said the magic words
but anyways, they are here, and they are either being chased by or fighting with a giant marshmallow man that looks like come out of a famous 80s movie!

Ghostbusters point their weird beam gun to the giant marshmallow man and fired.
This made the giant marshmallow man blow up and literally everywhere is covered with marshmallow, including your idea to have your future beverages with marshmallow!

When everything is calmed down, a few hours later, you order a frappucino again, this time with marshmallows(!).
Because you think everything is already covered with marshmallows.
The order goes into the queue with your marshmallows request.
But when the order is ready, you see your order does not have any marshmallows included.
When you ask this to the barista Emily, she says "there is no way to include marshmallows upon personal request, there are rules and there must be a shared contract for that; between the system and baristas and we don't have that.".

You ask this to Mr. Kafka, and he mentions something like a schema registry and something called Apicurio while drinking his hot chocolate slowly.
He pulls up a paper, a kind of contract from his suitcase carefully and gives it to you.
You can see the strange syntax and the `Avro` sign at the top of the page.

"Now it's your time to make a difference" says Kafka.
"Take this contract sample and hang it somewhere on the wall where baristas and the shop manager (and so the system) can take a look and agree on".

This makes a lot of sense to you. An agreement, a contract on what to include in the beverages, and by putting it on the wall everybody, including baristas, can check it from time to time and act upon it.

So by gathering everyone who works in the shop, you write the contract together, and both orders and the beverages should include marshmallows from now on!
You put the contract on the wall, everybody agreed upon it and on checking it out from time to time. So you think its now time for a beverage with marshmallows at last!

You make another order and nice, you get your marshmallow frappucino! (Just be sure you don't be diabetic coma after all these).

Since all the system works properly right now, you think it's a good time to play with the contract based coffee ordering.
You want to see what happens if the contract changes.
You walk to the wall and strike-through the marshmallows secretly and go back to your chair to watch what happens.

The contract change is visible, and the baristas easily notice the change.
With everything covered with marshmallows, how it would be possible to serve beverages without the marshmallow option!

The baristas could serve to no one. No orders can be created, so the order queue is empty.
You observed that as the new rule of the coffee shop, baristas can not disobey it -including the manager-, but accept it and agree on it.

Without causing any more issues to the coffee shop (and without making the coffee shop manager angry),
you write down the `marshmallows` option on the contract again and see the baristas take a deep breath and continue to receive orders with the marshmallow option.
