%% Generated with 'testgen v0.2.0'
%% Revision 1 of the exercises generator was used
%% https://github.com/exercism/problem-specifications/raw/42dd0cea20498fd544b152c4e2c0a419bb7e266a/exercises/two-fer/canonical-data.json
%% This file is automatically generated from the exercises canonical data.

-module(two_fer_tests).

-include_lib("erl_exercism/include/exercism.hrl").
-include_lib("eunit/include/eunit.hrl").


-define(assertStringEqual(Expect, Expr),
        begin ((fun () ->
            __X = (Expect),
            __Y = (Expr),
            case string:equal(__X, __Y) of
                true -> ok;
                false -> erlang:error({assertStringEqual,
                    [{module, ?MODULE},
                     {line, ?LINE},
                     {expression, (??Expr)},
                     {expected, unicode:characters_to_list(__X)},
                     {value, unicode:characters_to_list(__Y)}]})
            end
        end)())
    end).

-define(_assertStringEqual(Expect, Expr), ?_test(?assertStringEqual(Expect, Expr))).


'1_no_name_given_test_'() ->
    {"no name given",
     ?_assertStringEqual("One for you, one for me.",
			 two_fer:two_fer())}.

'2_a_name_given_test_'() ->
    {"a name given",
     ?_assertStringEqual("One for Alice, one for me.",
			 two_fer:two_fer("Alice"))}.

%%'3_another_name_given_test_'() ->
%%    {"another name given",
%%     ?_assertStringEqual("One for Bob, one for me.",
%%			 two_fer:two_fer("Bob"))}.
