# A Man, called Kafka, walks into a coffeeshop and...

> ## Pre-Demo Preparations
> 
> ### Install the prereqs:
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
## The Coffeeshop

It's been a hard year because of the pandemic, and when you learn the lockdown is over, you want to go to the coffee shop you used to go before pandemic.
It will be seen as the same old coffee shop, but so much not be sure about that, you will see a lot changed.

