# About [featured & toggled]

This project is study based to improve and learn more about redis and feature flags.

![Project Overview](./images/featured-toggled.png?raw=true)

## featured

`featured` makes available the endpoints to create, read, update the feature toggles. There are only two properties about it, name and status. The main idea is to improve cache knowledge and some Spring features.

folder reference: **featured**.

## toggled

On the other hand, `toggled` is the service that will consume the feature information to check wether a feature is active or disabled (*ON* or *OFF*).

folder reference: **toggled**.
