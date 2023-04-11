CREATE TABLE offer
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title      VARCHAR(255),
    tag        VARCHAR(255),
    start_date date,
    created_at TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    base       BIGINT,
    bonus      BIGINT,
    stock      BIGINT,
    currency   VARCHAR(255),
    name       VARCHAR(255),
    logo       VARCHAR(255),
    url        VARCHAR(255),
    total      BIGINT,
    at_company BIGINT,
    city       VARCHAR(255),
    country    VARCHAR(255),
    state      VARCHAR(255),
    type       VARCHAR(255),
    CONSTRAINT pk_offer PRIMARY KEY (id)
);