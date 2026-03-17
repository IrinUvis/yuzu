# Module graph

```mermaid
%%{
  init: {
    'theme': 'neutral'
  }
}%%

graph LR
  subgraph :core
    :core:logger["logger"]
    :core:design-system["design-system"]
    :core:common["common"]
  end
  subgraph :data
    :data:genai["genai"]
    :data:wordgeneration["wordgeneration"]
  end
  subgraph :domain
    :domain:genai["genai"]
    :domain:wordgeneration["wordgeneration"]
  end
  subgraph :feature
    :feature:wordgenerator["wordgenerator"]
  end
  :domain:genai --> :data:genai
  :domain:genai --> :core:logger
  :app --> :feature:wordgenerator
  :data:genai --> :core:logger
  :domain:wordgeneration --> :data:wordgeneration
  :domain:wordgeneration --> :data:genai
  :domain:wordgeneration --> :core:logger
  :data:wordgeneration --> :core:logger
  :feature:wordgenerator --> :core:design-system
  :feature:wordgenerator --> :domain:wordgeneration
  :feature:wordgenerator --> :domain:genai
  :feature:wordgenerator --> :core:common
```